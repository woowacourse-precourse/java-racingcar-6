package racingcar.common;

import java.util.List;

public class Convert {
    public static List<String> stringToListByComma(String string) {
        return List.of(string.split(","));
    }

    public static Integer stringToInteger(String stringAttemptNumber) {
        try {
            int integerAttemptNumber = Integer.parseInt(stringAttemptNumber);
            validatePositive(integerAttemptNumber);
            return integerAttemptNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private static void validatePositive(int integerAttemptNumber) {
        if (integerAttemptNumber < 0) {
            throw new IllegalArgumentException();
        }
    }
}
