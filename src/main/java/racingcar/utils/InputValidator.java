package racingcar.utils;

public class InputValidator {

    public static void gameCountValidate(String input) {
        if (isNotInteger(input) || input.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    public static boolean isNotInteger(String input) {
        try {
            Integer.parseInt(input);
            return false;
        } catch (NumberFormatException numberFormatException) {
            return true;
        }
    }
}
