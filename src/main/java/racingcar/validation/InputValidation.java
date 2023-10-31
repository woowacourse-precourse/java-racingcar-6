package racingcar.validation;

import static racingcar.constant.IllegalArgumentMessage.EMPTY_INPUT;

public abstract class InputValidation {

    public static void isEmptyInput(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(EMPTY_INPUT.getMessage());
        }
    }
}
