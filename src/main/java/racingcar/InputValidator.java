package racingcar;

public class InputValidator {

    public static void blank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessages.BLANK_INPUT_ERROR_MESSAGE);
        }
    }
}
