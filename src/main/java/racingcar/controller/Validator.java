package racingcar.controller;

import static racingcar.view.messages.ErrorMessages.ERROR_TRY_COUNT_NUMERIC;
import static racingcar.view.messages.ErrorMessages.ERROR_TRY_COUNT_RANGE;

public class Validator {
    private static final String TRY_COUNT_PATTERN = "^[0-9]+$";

    public static void validateTryCount(String tryCount) {
        validateTryCountNumeric(tryCount);
        validateTryCountRange(tryCount);
    }

    private static void validateTryCountNumeric(String tryCount) {
        if (!tryCount.matches(TRY_COUNT_PATTERN)) {
            throw new IllegalArgumentException(ERROR_TRY_COUNT_NUMERIC.getErrorMessage());
        }
    }

    private static void validateTryCountRange(String tryCount) {
        if (Integer.parseInt(tryCount) < 1) {
            throw new IllegalArgumentException(ERROR_TRY_COUNT_RANGE.getErrorMessage());
        }
    }
}
