package racingcar.validation;

import static racingcar.constant.IllegalArgumentMessage.EMPTY_INPUT;

public class InputValidation {

    private InputValidation() {
    }

    public static void isEmptyInput(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(EMPTY_INPUT.getMessage());
        }
    }
}
