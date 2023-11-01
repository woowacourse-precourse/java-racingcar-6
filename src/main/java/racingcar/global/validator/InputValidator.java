package racingcar.global.validator;

import racingcar.global.enums.ExceptionMessage;

public class InputValidator {

    public static void validateNullOrEmptyInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.NULL_OR_EMPTY_INPUT_MESSAGE.getMessage());
        }
    }

    public static void validateInputIsNumeric(String input) {
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException(ExceptionMessage.NON_NUMERIC_INPUT_ERROR_MESSAGE.getMessage());
            }
        }
    }

}
