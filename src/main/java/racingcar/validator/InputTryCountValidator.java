package racingcar.validator;

import racingcar.utils.ErrorMessage;
import racingcar.view.InputConverter;

public class InputTryCountValidator {

    public int validateAndConvert(String input) {
        validateTryCountIsBlank(input);
        int tryCount = validateIsInteger(input);
        validatePositiveInteger(tryCount);
        return tryCount;
    }

    public void validateTryCountIsBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.TRY_COUNT_DOES_NOT_BLANK.getMessage());
        }
    }

    public int validateIsInteger(String input) {
        try {
            return InputConverter.convertToInteger(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.TRY_COUNT_MUST_BE_INTEGER.getMessage(), e);
        }
    }

    public void validatePositiveInteger(int tryCount) {
        if (tryCount <= 0) {
            throw new IllegalArgumentException(ErrorMessage.TRY_COUNT_MUST_BE_POSITIVE_INTEGER.getMessage());
        }
    }
}
