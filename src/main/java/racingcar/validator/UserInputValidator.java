package racingcar.validator;

import java.util.Collections;
import java.util.List;
import racingcar.ErrorMessage;

public class UserInputValidator {

    private UserInputValidator() {
    }

    public static void validCarNameLength(String userInput) {
        if (userInput.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_LENGTH_EXCEPTION.getMessage());
        }
    }

    public static void validCarNameIsDuplicated(List<String> carNames) {
        for (String carName : carNames) {
            if (Collections.frequency(carNames, carName) > 1) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE_CAR_NAME.getMessage());
            }
        }

    }
}
