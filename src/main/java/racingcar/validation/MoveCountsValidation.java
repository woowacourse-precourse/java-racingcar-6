package racingcar.validation;

import racingcar.utils.Constants;
import racingcar.utils.ErrorMessage;

public class MoveCountsValidation {
    public void validateMoveCountsInput(String input) {
        validateIsInteger(input);
        validateIsGreaterThanOne(input);
    }

    private void validateIsInteger(String input) {
        if (!isInteger(input)) {
            throw new IllegalArgumentException(ErrorMessage.MOVE_COUNTS_NOT_INT_ERROR_MESSAGE);
        }
    }

    private void validateIsGreaterThanOne(String input) {
        int moveCounts = Integer.parseInt(input);
        if (moveCounts < Constants.MINIMUM_MOVE_COUNTS_FOR_INPUT) {
            throw new IllegalArgumentException(ErrorMessage.MOVE_COUNTS_RANGE_ERROR_MESSAGE);
        }
    }

    private boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
