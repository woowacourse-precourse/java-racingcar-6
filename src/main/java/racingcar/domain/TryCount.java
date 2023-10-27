package racingcar.domain;

import static racingcar.util.ErrorMessage.INVALID_NUMBER_ERROR;
import static racingcar.util.ErrorMessage.NEGATIVE_NUMBER_ERROR;

public record TryCount(int value) {

    public TryCount {
        checkCount(value);
    }

    private void checkCount(int count) {
        checkPositive(count);
        checkMax(count);
    }

    private void checkPositive(int count) {
        if (isNotPositive(count)) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER_ERROR.getMessage());
        }
    }

    private static boolean isNotPositive(int count) {
        return count <= 0;
    }

    private void checkMax(int count) {
        if (count >= Integer.MAX_VALUE) {
            throw new IllegalArgumentException(INVALID_NUMBER_ERROR.getMessage());
        }
    }
}
