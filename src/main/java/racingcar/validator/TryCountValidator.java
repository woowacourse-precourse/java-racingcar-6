package racingcar.validator;

import racingcar.constants.MessageConstants;

public class TryCountValidator {

    public static void validateTryCount(String inputTryCount) {
        int tryCount = checkNoInteger(inputTryCount);
        checkZeroOrNegative(tryCount);
    }

    private static int checkNoInteger(String inputTryCount) {
        try {
            return Integer.parseInt(inputTryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(MessageConstants.INVALID_NUMBER_FORMAT);
        }
    }

    private static void checkZeroOrNegative(int tryCount) {
        if (tryCount <= 0) {
            throw new IllegalArgumentException(MessageConstants.INVALID_TRY_COUNT);
        }
    }
}
