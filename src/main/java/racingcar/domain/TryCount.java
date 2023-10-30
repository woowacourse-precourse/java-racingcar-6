package racingcar.domain;

import racingcar.constants.ExceptionMessage;

public class TryCount {
    private final int ONE = 1;
    private int tryCount;

    public TryCount(final int tryCount) {
        validateTryCount(tryCount);
        this.tryCount = tryCount;
    }

    private void validateTryCount(final int tryCount) {
        if (tryCount < ONE) {
            ExceptionMessage.INVALID_INPUT_ERROR_MESSAGE.throwException();
        }
    }

    public void decreaseCount() {
        tryCount--;
    }

    public boolean hasRepeat() {
        return tryCount >= ONE;
    }

    public int getTryCount() {
        return tryCount;
    }
}
