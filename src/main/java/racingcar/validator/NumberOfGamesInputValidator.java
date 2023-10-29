package racingcar.validator;

import racingcar.constant.NumberOfGamesInputErrorMessage;

public class NumberOfGamesInputValidator {
    public void validate(String userInput) {
        isNumeric(userInput);
    }

    private void isNumeric(String userInput) {
        try {
            Long.parseLong(userInput);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(NumberOfGamesInputErrorMessage.INPUT_NOT_NUMERIC_TYPE);
        }
    }
}
