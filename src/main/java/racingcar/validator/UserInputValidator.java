package racingcar.validator;

import java.util.Objects;
import racingcar.ErrorMessage;

public class UserInputValidator {

    private UserInputValidator() {
    }

    public static void validCarNameLength(String userInput) {
        if (userInput.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_LENGTH_EXCEPTION.getMessage());
        }
    }

    public static void validCarNameIsDuplicated(String[] userInput) {

        for (int i = 1; i < userInput.length; i++) {
            if (Objects.equals(userInput[i], userInput[i - 1])) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE_CAR_NAME.getMessage());
            }
        }
    }
}
