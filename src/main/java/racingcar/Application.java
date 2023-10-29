package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static List<String> inputCarNameList() {
        String[] stringArray = Console.readLine().split(",");
        return List.of(stringArray);
    }

    public static List<Car> getCarsFromInput() {
        List<String> carNameList = inputCarNameList();
        boolean isLengthExceed = carNameList.stream().anyMatch(carName -> carName.length() > 5);
        if (isLengthExceed) {
            throw new IllegalArgumentException();
        }
        return carNameList.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public static int inputMoveCount() {
        String input = Console.readLine();
        int moveCount;
        try {
            moveCount = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        if (moveCount < 0) {
            throw new IllegalArgumentException();
        }
        return moveCount;
    }

    public static int pick1DigitRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public static void main(String[] args) {
        List<Car> cars = getCarsFromInput();
        int moveCount = inputMoveCount();
        for (int i = 0; i < moveCount; i++) {
            cars.forEach(Car::tryMoveForward);
        }
    }
}
