package util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import racingcar.model.Car;

public final class Validator {
    private static final Pattern CAR_NAME_PATTERN = Pattern.compile("^[a-zA-Z0-9,\\s가-힣ㄱ-ㅎㅏ-ㅣ]*$");
    private static final String CAR_NAME_SEPARATOR = ",";
    private static final int INITIAL_POSITION = 0;
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final int MIN_CAR_LIST_SIZE = 2;
    private static final int MIN_NUMBER_OF_ATTEMPTS = 1;

    /**
     * @param input 사용자가 입력한 자동차 이름 목록
     * @return 쉽표(, )를 기준으로 구분하여 앞뒤 공백 제거 후 자동차 이름 리스트 반환
     */
    public static List<Car> parseCarNames(String input) {
        validateCarNameFormat(input);
        List<Car> cars = Stream.of(input.split(CAR_NAME_SEPARATOR))
                .map(name -> new Car(name.strip(), INITIAL_POSITION))
                .toList();
        validateCarNameNotEmpty(cars);
        validateCarNameLengths(cars);
        validateCarListSize(cars);
        validateCarNameUniqueness(cars);
        return cars;
    }

    /**
     * @param input 영문 대소문자, 숫자, 쉼표, 공백, 한글 허용
     */
    private static void validateCarNameFormat(String input) {
        if (!input.matches(CAR_NAME_PATTERN.pattern())) {
            throw new IllegalArgumentException(Exception.INVALID_CAR_NAME_FORMAT.getMessage());
        }
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
            if (car.getName().length() > MAX_CAR_NAME_LENGTH) {
                throw new IllegalArgumentException(Exception.CAR_NAME_TOO_LONG.getMessage());
            }
        }
    }

    private static void validateCarListSize(List<Car> cars) {
        if (cars.size() < MIN_CAR_LIST_SIZE) {
            throw new IllegalArgumentException(Exception.CAR_LIST_SIZE_TOO_LITTLE.getMessage());
        }
    }

    private static void validateCarNameUniqueness(List<Car> cars) {
        Set<String> carNames = new HashSet<>();
        for (Car car : cars) {
            if (!carNames.add(car.getName())) {
                throw new IllegalArgumentException(Exception.CAR_NAME_NOT_UNIQUE.getMessage());
            }
        }
    }

    public static int parseNumberOfAttempts(String input) {
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
        if (numberOfAttempts < MIN_NUMBER_OF_ATTEMPTS) {
            throw new IllegalArgumentException(Exception.NUMBER_OF_ATTEMPT_TOO_LITTLE.getMessage());
        }
    }
}
