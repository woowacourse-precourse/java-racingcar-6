package racingcar.utils;

public class InputValidator {
    public static void carNameValidate(String[] carNames) {
        for (String name : carNames) {
            if (name.isBlank() || name.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }

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
