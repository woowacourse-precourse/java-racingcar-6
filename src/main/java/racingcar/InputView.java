package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputView {
    public static List<Car> inputCarsInfo() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return getCarNames();
    }

    public static List<Car> getCarNames() {
        String input = Console.readLine();
        String[] carNames = input.split(",");

        for (String carName : carNames) {
            validateCarName(carName);
        }
        validateDuplicate(carNames);

        return convertStringArrayToCarList(carNames);
    }

    public static void validateCarName(String carName) {
        validateLength(carName);
        validateBlank(carName);
    }

    public static void validateLength(String carName) {
        if (!isValidLength(carName)) {
            throw new IllegalArgumentException();
        }
    }

    public static boolean isValidLength(String carName) {
        return carName.length() >= 1 && carName.length() <= 5;
    }

    public static void validateBlank(String carName) {
        if (carName.contains(" ")) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateDuplicate(String[] carNames) {
        Set<String> uniqueCarNames = new HashSet<>(Arrays.asList(carNames));

        if (uniqueCarNames.size() != carNames.length) {
            throw new IllegalArgumentException();
        }
    }

    public static List<Car> convertStringArrayToCarList(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName, 0));
        }
        return cars;
    }

    public static int inputRound() {
        System.out.println("시도할 회수는 몇회인가요?");
        return getRound();
    }

    public static int getRound() {
        String input = Console.readLine();
        return validateRound(input);
    }

    public static int validateRound(String input) {
        int round = validateRoundType(input);
        isValidRoundRange(round);
        return round;
    }

    public static int validateRoundType(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static void isValidRoundRange(int round) {
        if (round <= 0) {
            throw new IllegalArgumentException();
        }
    }
}
