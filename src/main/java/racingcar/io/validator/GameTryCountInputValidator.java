package racingcar.io.validator;

import static racingcar.exception.ExceptionMessage.InputException.GAME_TRY_COUNT_MUST_BE_NUMERIC;
import static racingcar.exception.ExceptionMessage.InputException.INPUT_MUST_NOT_CONTAINS_SPACE;

public class GameTryCountInputValidator {
    public void validate(final String userInput) {
        validateInputHasSpace(userInput);
        validateInputIsNumeric(userInput);
    }

    private void validateInputHasSpace(final String userInput) {
        if (hasSpace(userInput)) {
            throw new IllegalArgumentException(INPUT_MUST_NOT_CONTAINS_SPACE.message);
        }
    }

    private boolean hasSpace(final String userInput) {
        return userInput.chars()
                .anyMatch(Character::isWhitespace);
    }

    private void validateInputIsNumeric(final String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (final NumberFormatException exception) {
            throw new IllegalArgumentException(GAME_TRY_COUNT_MUST_BE_NUMERIC.message);
        }
    }
}
