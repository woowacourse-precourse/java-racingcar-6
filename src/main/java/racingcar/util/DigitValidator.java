package racingcar.util;

public class DigitValidator {
    public static String STRING_ZERO = "0";

    public static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);

            return !input.startsWith(STRING_ZERO);
        } catch (NumberFormatException exception) {
            return false;
        }
    }
}
