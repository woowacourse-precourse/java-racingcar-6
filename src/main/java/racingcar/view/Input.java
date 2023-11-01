package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Input {
    private static final String NON_NUMERIC_EXCEPTION = "숫자만을 입력해주십시오.";

    public static List<String> inputCarName() {
        return inputCarNameToArray(Console.readLine());
    }

    private static List<String> inputCarNameToArray(String userInput) {
        List<String> cars = new ArrayList<>();

        for (String car : userInput.split(",")) {
            cars.add(car);
        }

        return cars;
    }

    public static int inputNumberForMove() {
        return inputNumberToInteger(Console.readLine());
    }

    public static int inputNumberToInteger(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_NUMERIC_EXCEPTION);
        }
    }
}
