package racingcar.domain;

import static racingcar.util.ExceptionMessage.NOT_NUMERIC;

public class TryCount {

    private final int count;

    private TryCount(final int count) {
        this.count = count;
    }

    public static TryCount of(final int count) {
        checkPositive(count);
        return new TryCount(count);
    }

    private static void checkPositive(final int count) {
        if (count <= 0) {
            throw new IllegalArgumentException(NOT_NUMERIC.getMessage());
        }
    }

    public int getCount() {
        return count;
    }
}
