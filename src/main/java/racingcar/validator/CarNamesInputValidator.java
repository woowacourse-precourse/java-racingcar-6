package racingcar.validator;

import racingcar.constant.Constant;
import racingcar.constant.ErrorMessage;

public class CarNamesInputValidator {
    public void validate(String userInput) {
        isNotEmpty(userInput);
        containsDelimiter(userInput);
    }

    private void isNotEmpty(String userInput) {
        if (userInput.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_CAR_NAMES_EMPTY);
        }
    }

    private void containsDelimiter(String userInput) {
        if (!userInput.contains(Constant.INPUT_CAR_NAMES_DELIMITER)) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_CAR_NAMES_NOT_CONTAIN_DELIMITER);
        }
    }
}
