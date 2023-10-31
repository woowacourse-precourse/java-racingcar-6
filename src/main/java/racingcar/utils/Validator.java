package racingcar.utils;

import racingcar.message.ErrorMessage;

public class Validator {
    public static void checkRoundValidation(String roundInputString) {
        if (!roundInputString.matches("^[0-9]*$")) {
            throw new IllegalArgumentException(ErrorMessage.roundValidationError);
        }
        if (roundInputString.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.nullInputError);
        }
    }

    public static void checkCarNameValidation(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.carNameValidationError);
        }
    }
}
