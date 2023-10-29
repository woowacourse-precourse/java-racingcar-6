package racingcar.validator;

import racingcar.constant.Constant;
import racingcar.constant.NumberOfGamesInputErrorMessage;

public class NumberOfGamesInputValidator {
    public void validate(String userInput) {
        isNotEmpty(userInput);
        isNumeric(userInput);
        isMoreThanLowerLimit(userInput);
    }

    private void isNotEmpty(String userInput) {
        if (userInput.isEmpty()) {
            throw new IllegalArgumentException(NumberOfGamesInputErrorMessage.INPUT_IS_EMPTY);
        }
    }

    private void isNumeric(String userInput) {
        try {
            Long.parseLong(userInput);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(NumberOfGamesInputErrorMessage.INPUT_IS_NOT_NUMERIC_TYPE);
        }
    }

    private void isMoreThanLowerLimit(String userInput) {
        long inputNumberOfGames = Long.parseLong(userInput);
        if (inputNumberOfGames < Constant.NUMBER_OF_GAMES_LOWER_LIMIT) {
            throw new IllegalArgumentException(NumberOfGamesInputErrorMessage.INPUT_IS_LOWER_THAN_LIMIT);
        }
    }
}
