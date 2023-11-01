package racingcar.utils;

public class StringValidateUtils {
    private StringValidateUtils() {
    }

    public static void validateEmptyString(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateStringLength(String input, int length) {
        if (input.length() > length) {
            throw new IllegalArgumentException();
        }
    }
}
