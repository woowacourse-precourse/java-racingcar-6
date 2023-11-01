package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Cars {
    private static final String INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String DELIMITER = ",";
    private static final String LENGTH_EXCEPTION = "자동차 이름은 5자 이하만 가능하다.";
    private static final String NON_NUMBER_EXCEPTION = "자동차 이름에는 숫자가 포함될 수 없습니다.";
    private static final String NON_WINNER = "우승자가 없습니다.";
    private static final int NAME_LENGTH = 5;
    private final List<Car> cars = new ArrayList<>();

    public void createCars() {
        String[] carNames = inputCarNames();
        for (String carName : carNames) {
            if (isValidCarNameLength(carName)) {
                Car car = new Car(carName);
                cars.add(car);
            }
        }
    }

    private static String[] inputCarNames() {
        System.out.println(INPUT_CAR_NAMES);
        String input = Console.readLine();
        if (isContainsDigit(input)) {
            throw new IllegalArgumentException(NON_NUMBER_EXCEPTION);
        }
        return input.split(DELIMITER);
    }

    private static boolean isContainsDigit(String str) {
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isValidCarNameLength(String carName) {
        if (carName.length() >= NAME_LENGTH) {
            throw new IllegalArgumentException(LENGTH_EXCEPTION);
        }
        return true;
    }

    public void move() {
        for (Car car : cars) {
            car.move();
        }
    }

    public void isWinner() {
        int maxPosition = getMaxPosition();
        List<String> winners = getWinners(maxPosition);

        if (!winners.isEmpty()) {
            System.out.println("최종 우승자 : " + String.join(", ", winners));
        } else {
            System.out.println(NON_WINNER);
        }
    }

    private int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    private List<String> getWinners(int maxPosition) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
