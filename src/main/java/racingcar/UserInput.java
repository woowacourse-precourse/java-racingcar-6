package racingcar;

import java.util.Arrays;
import java.util.List;

public class UserInput {
    public List<String> getCarNamesInput(String inputNames) {
        List<String> carNames = Arrays.asList(inputNames.split(","));

        if (!isNotEmpty(carNames)) {
            throw new IllegalArgumentException();
        }

        if (!isUnderSixDigit(carNames)) {
            throw new IllegalArgumentException();
        }

        return carNames;
    }

    public int getTryTimeInput(String inputTime) {
        if (!isNumberInteger(inputTime)) {
            throw new IllegalArgumentException();
        }

        int tryTime = Integer.parseInt(inputTime);
        if (!isNumberOverZero(tryTime)) {
            throw new IllegalArgumentException();
        }

        return tryTime;
    }

    public static boolean isNumberInteger(String input) {
        String regularExpression = "^[0-9]+$";
        return input.matches(regularExpression);

    }

    public static boolean isUnderSixDigit(List<String> inputs) {
        for (String input : inputs) {
            if (input.length() > 5) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNotEmpty(List<String> inputs) {
        for (String input : inputs) {
            if (input.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNumberOverZero(int input) {
        return input > 0;
    }
}
