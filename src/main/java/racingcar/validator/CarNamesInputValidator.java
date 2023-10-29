package racingcar.validator;

import racingcar.constant.ErrorMessage;

public class CarNamesInputValidator {
    public void validate(String userInput) {
        isNotEmpty(userInput);
    }

    private void isNotEmpty(String userInput) {
        if (userInput.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_CAR_NAMES_EMPTY);
        }
    }
}
