package racingcar.validator;

import racingcar.utils.ErrorMessage;
import racingcar.view.InputConverter;

public class InputTryCountValidator {

    public int validateAndConvert(String input) {
        int tryCount = validateIsInteger(input);
        validatePositiveInteger(tryCount);
        return tryCount;
    }

    public int validateIsInteger(String input) {
        try {
            return InputConverter.convertToInteger(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.TRY_COUNT_MUST_BE_INTEGER.getMessage(), e);
        }
    }

    private void validatePositiveInteger(int tryCount) {
        if (tryCount <= 0) {
            throw new IllegalArgumentException(ErrorMessage.TRY_COUNT_MUST_BE_POSITIVE_INTEGER.getMessage());
        }
    }

}
