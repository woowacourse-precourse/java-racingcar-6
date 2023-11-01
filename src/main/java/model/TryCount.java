package model;

import static model.ErrorMessage.INVALID_RANGE;
import static model.ErrorMessage.INVALID_TYPE;

public class TryCount {

    private static final int MIN_TRY_COUNT = 1;
    private static final int ZERO_COUNT_VALUE = 0;
    private static final int ONE_TIME_VALUE = 1;

    private int tryCount;

    private TryCount(final int tryCount) {
        this.tryCount = tryCount;
    }

    public static TryCount from(final String value) {
        validateDigitValue(value);

        int intValue = Integer.parseInt(value);
        validateRange(intValue);

        return new TryCount(intValue);
    }

    public boolean canUseCount() {
        return tryCount > ZERO_COUNT_VALUE;
    }

    public void useOneCount() {
        tryCount -= ONE_TIME_VALUE;
    }

    private static void validateRange(final int intValue) {
        if (isInValidRange(intValue)) {
            throw new IllegalArgumentException(INVALID_RANGE.getMessage());
        }
    }

    private static void validateDigitValue(final String value) {
        if (!isDigit(value)) {
            throw new IllegalArgumentException(INVALID_TYPE.getMessage());
        }
    }

    private static boolean isInValidRange(final int intValue) {
        return intValue < MIN_TRY_COUNT;
    }

    private static boolean isDigit(final String value) {
        return value.chars()
            .allMatch(Character::isDigit);
    }
}
