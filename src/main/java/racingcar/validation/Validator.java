package racingcar.validation;

import java.util.List;

public class Validator {
    public static void validateCarsInput(List<String> cars) {
        for (String car : cars) {
            if (car.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void validateTurnInput(String turn) {
        if (!isInteger(turn) || Integer.parseInt(turn) < 0) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isInteger(String str) {
        if (str == null) {
            return false;
        }
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
