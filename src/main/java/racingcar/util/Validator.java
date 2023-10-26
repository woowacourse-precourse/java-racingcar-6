package racingcar.util;

public class Validator {
    public static void isEmpty(String input) {
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_VALUE);
        }
    }
}
