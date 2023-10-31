package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RacingGame {
    public void startGame() {
        List<Car> cars = inputCarsInfo();
        int round = inputRound();
        System.out.println("실행 결과");
        for (int count = 1; count <= round; count++) {
            proceedRound(cars);
            System.out.println();
        }
        printWinner(cars);
    }

    private List<Car> inputCarsInfo() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return getCarNames();
    }

    private List<Car> getCarNames() {
        String input = Console.readLine();
        String[] carNames = input.split(",");

        for (String carName : carNames) {
            validateCarName(carName);
        }
        validateDuplicate(carNames);

        List<Car> cars = convertStringArrayToCarList(carNames);
        return cars;
    }

    private void validateCarName(String carName) {
        validateLength(carName);
        validateBlank(carName);
    }

    private void validateLength(String carName) {
        if (!isValidLength(carName)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isValidLength(String carName) {
        return carName.length() >= 1 && carName.length() <= 5;
    }

    private void validateBlank(String carName) {
        if (carName.contains(" ")) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(String[] carNames) {
        Set<String> uniqueCarNames = new HashSet<>(Arrays.asList(carNames));

        if (uniqueCarNames.size() != carNames.length) {
            throw new IllegalArgumentException();
        }
    }

    private List<Car> convertStringArrayToCarList(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName, 0));
        }
        return cars;
    }

    private int inputRound() {
        System.out.println("시도할 회수는 몇회인가요?");
        return getRound();
    }

    private int getRound() {
        String input = Console.readLine();
        return validateRound(input);
    }

    private int validateRound(String input) {
        int round = validateRoundType(input);
        isValidRoundRange(round);
        return round;
    }

    private int validateRoundType(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void isValidRoundRange(int round) {
        if (round <= 0) {
            throw new IllegalArgumentException();
        }
    }

    private void printWinner(List<Car> cars) {
        StringBuilder result = new StringBuilder();
        result.append(String.join(",", getWinnerNames(cars)));
        result.append("가 최종 우승했습니다.");
        System.out.println(result);
    }

    private void proceedRound(List<Car> cars) {
        for (Car car : cars) {
            car.move();
            System.out.println(car.makeMoveResult());
        }
    }

    private List<String> getWinnerNames(List<Car> cars) {
        List<String> winners = new ArrayList<>();
        int maxPosition = Integer.MIN_VALUE;

        for (Car car : cars) {
            int position = car.getPosition();

            if (position > maxPosition) {
                maxPosition = position;
                winners.clear();
                winners.add(car.getName());
            }
            if (position == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
