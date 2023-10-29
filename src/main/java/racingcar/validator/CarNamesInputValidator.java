package racingcar.validator;

import racingcar.constant.Constant;

public class CarNamesInputValidator {
    public void validate(String userInput) {
        isNotEmpty(userInput);
    }

    private void isNotEmpty(String userInput) {
        if (userInput.isEmpty()) {
            throw new IllegalArgumentException(Constant.ERROR_INPUT_CAR_NAMES_EMPTY);
        }
    }
}
