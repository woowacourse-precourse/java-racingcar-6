package validator;

import message.ErrorMessages;

public class TryCountValidator {

    public void validateTryCountNumber(String tryCount) {
        try {
            Integer.parseInt(tryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.COUNT_NOT_NUMBER_ERROR);
        }
    }

    public void validateTryCountMin(String tryCount) {
        if (Integer.parseInt(tryCount) < 1) {
            throw new IllegalArgumentException(ErrorMessages.TRY_COUNT_MIN_ERROR);
        }
    }
}
