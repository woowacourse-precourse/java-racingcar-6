package racingcar.validator;

import racingcar.ErrorMessage;

public class UserInputValidator {

    private UserInputValidator() {
    }

    public static void validCarNameLength(String userInput) {
        if (userInput.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_LENGTH_EXCEPTION.getMessage());
        }
    }
}
