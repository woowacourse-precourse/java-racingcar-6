package validator;

import static message.Constants.TRY_COUNT_MIN;
import static message.ErrorMessages.COUNT_NOT_NUMBER_ERROR;
import static message.ErrorMessages.TRY_COUNT_MIN_ERROR;

public class TryCountValidator {

    public static void validateTryCountNumber(String tryCount) {
        try {
            Integer.parseInt(tryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(COUNT_NOT_NUMBER_ERROR);
        }
    }

    public static void validateTryCountMin(String tryCount) {
        if (Integer.parseInt(tryCount) < TRY_COUNT_MIN) {
            throw new IllegalArgumentException(TRY_COUNT_MIN_ERROR);
        }
    }
}
