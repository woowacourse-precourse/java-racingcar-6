package racingcar.validation;

import static racingcar.constant.Constant.ERROR_EMPTY_INPUT_MESSAGE;

public abstract class InputValidation {

    public static void isEmptyInput(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ERROR_EMPTY_INPUT_MESSAGE);
        }
    }
}
