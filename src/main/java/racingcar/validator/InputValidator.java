package racingcar.validator;

import static racingcar.enums.ExceptionMessage.NON_NUMERIC_INPUT_ERROR_MESSAGE;
import static racingcar.enums.ExceptionMessage.NULL_OR_EMPTY_INPUT_MESSAGE;

public class InputValidator {

    public static void validateNullOrEmptyInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(NULL_OR_EMPTY_INPUT_MESSAGE.getMessage());
        }
    }

    public static void validateTryCount(String input) {
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException(NON_NUMERIC_INPUT_ERROR_MESSAGE.getMessage());
            }
        }
    }

}
