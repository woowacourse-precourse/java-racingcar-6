package racingcar.input;

import racingcar.constants.Message;

public class InputValidator {
    public static String validate(String input) {
        if (input == null || input.isEmpty() || input.isBlank()) {
            throw new IllegalArgumentException(Message.EMPTY_STRING);
        }
        return input.trim();
    }
}
