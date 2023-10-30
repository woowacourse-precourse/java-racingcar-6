package racingcar.model;

import java.util.Objects;
import racingcar.exception.NonPositiveIntException;

public class TryCount {

    private static final int MIN_COUNT_VALUE = 1;
    private static final int ZERO_COUNT_VALUE = 0;

    private int tryCount;

    private TryCount(final int tryCount) {
        this.tryCount = tryCount;
    }

    public static TryCount from(final String count) {
        validateNumericValue(count);
        int intValue = Integer.parseInt(count);
        validateRange(intValue);

        return new TryCount(intValue);
    }

    private static void validateNumericValue(final String value) {
        if (!isNumeric(value)) {
            throw new NonPositiveIntException();
        }
    }

    private static boolean isNumeric(final String value) {
        return value.chars()
                .allMatch(Character::isDigit);
    }

    private static void validateRange(final int intValue) {
        if (isInValidRange(intValue)) {
            throw new NonPositiveIntException();
        }
    }

    private static boolean isInValidRange(final int intValue) {
        return intValue < MIN_COUNT_VALUE;
    }

    public boolean isEnd() {
        return tryCount <= ZERO_COUNT_VALUE;
    }

    public void decrease() {
        tryCount--;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TryCount tryCount1 = (TryCount) o;
        return tryCount == tryCount1.tryCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tryCount);
    }
}
