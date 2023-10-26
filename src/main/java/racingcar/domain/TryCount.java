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
        if (count <= 0) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER_ERROR.getMessage());
        }
    }

    private void checkMax(int count) {
        if (count >= Integer.MAX_VALUE) {
            throw new IllegalArgumentException(INVALID_NUMBER_ERROR.getMessage());
        }
    }
}
