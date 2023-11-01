package racingcar.domain;

import static racingcar.exception.ExceptionMsg.INVALID_INPUT_NUMBER;
import static racingcar.exception.ExceptionMsg.INVALID_INPUT_NUMBER_RANGE;

public class TryInput {

    private static final int MIN_RANGE = 0;
    private final int tryCount;


    public TryInput(String tryCount) {
        this.tryCount = validateTryCount(tryCount);
    }

    public int getTryCount() {
        return tryCount;
    }

    private static int validateTryCount(String tryCount) {
        validateNumber(tryCount);

        int tryNum = validateRange(tryCount);

        return tryNum;
    }

    private static int validateRange(String tryCount) {
        int tryNum = validateUnderMaxRange(tryCount);
        validateOverMinRange(tryNum);

        return tryNum;
    }

    private static int validateUnderMaxRange(String tryCount) {
        try {
            int tryNum = Integer.parseInt(tryCount);

            return tryNum;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT_NUMBER_RANGE.getMessage());
        }
    }

    private static void validateOverMinRange(int tryNum) {
        if (tryNum <= MIN_RANGE) {
            throw new IllegalArgumentException(INVALID_INPUT_NUMBER_RANGE.getMessage());
        }
    }

    private static void validateNumber(String tryCount) {
        if (!tryCount.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(INVALID_INPUT_NUMBER.getMessage());
        }
    }
}
