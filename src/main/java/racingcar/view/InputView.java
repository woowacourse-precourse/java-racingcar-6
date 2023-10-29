package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Stream;
import racingcar.model.Car;
import util.Exception;

public final class InputView {

    public static List<Car> getCarNames() {
        OutputView.displayInitCarNames();
        String input = Console.readLine();
        return parseCarNames(input);
    }

    public static int getNumberOfAttempts() {
        OutputView.displayInitNumberOfAttempts();
        String input = Console.readLine();
        return parseNumberOfAttempts(input);
    }

    /**
     * @param input 사용자가 입력한 자동차 이름 목록
     * @return 쉽표(, )를 기준으로 구분하여 앞뒤 공백 제거 후 자동차 이름 리스트 반환
     */
    private static List<Car> parseCarNames(String input) {
        validateInputCharacters(input);
        List<Car> cars = Stream.of(input.split(","))
                .map(name -> new Car(name.strip(), 0))
                .toList();
        validateCarNameNotEmpty(cars);
        validateCarNameLengths(cars);
        validateCarListSize(cars);
        return cars;
    }

    /**
     * @param cars 자동차 이름을 입력하지 않거나 공백만 입력하면 예외 발생
     */
    private static void validateCarNameNotEmpty(List<Car> cars) {
        for (Car car : cars) {
            if (car.getName().isBlank()) {
                throw new IllegalArgumentException(Exception.CAR_NAME_NOT_EMPTY.getMessage());
            }
        }
    }

    private static void validateCarNameLengths(List<Car> cars) {
        for (Car car : cars) {
            if (car.getName().length() > 5) {
                throw new IllegalArgumentException(Exception.CAR_NAME_TOO_LONG.getMessage());
            }
        }
    }

    private static void validateCarListSize(List<Car> cars) {
        if (cars.size() < 2) {
            throw new IllegalArgumentException(Exception.CAR_LIST_SIZE_TOO_LITTLE.getMessage());
        }
    }

    private static int parseNumberOfAttempts(String input) {
        validateInputCharacters(input);
        int numberOfAttempts;
        try {
            numberOfAttempts = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Exception.INVALID_NUMBER_FORMAT.getMessage());
        }
        validateNumberOfAttempts(numberOfAttempts);
        return numberOfAttempts;
    }

    private static void validateNumberOfAttempts(int numberOfAttempts) {
        if (numberOfAttempts <= 0) {
            throw new IllegalArgumentException(Exception.NUMBER_OF_ATTEMPT_TOO_LITTLE.getMessage());
        }
    }

    /**
     * @param input 영문 대소문자, 숫자, 쉼표, 공백, 한글 허용
     */
    private static void validateInputCharacters(String input) {
        if (!input.matches("^[a-zA-Z0-9,\\s가-힣ㄱ-ㅎㅏ-ㅣ]*$")) {
            throw new IllegalArgumentException(Exception.INVALID_CHARACTER_FORMAT.getMessage());
        }
    }
}
