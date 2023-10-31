package racingcar.util;

import static racingcar.exception.ExceptionMessage.INPUT_IS_NOT_DIGIT;

public class DigitValidator {
    public static String STRING_ZERO = "0";

    public static void validateIsInteger(String input) {
        if (!isInteger(input)) {
            throw new IllegalArgumentException(INPUT_IS_NOT_DIGIT);
        }
    }

    public static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);

            return !input.startsWith(STRING_ZERO);
        } catch (NumberFormatException exception) {
            return false;
        }
    }
}
