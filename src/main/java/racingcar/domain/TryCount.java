package racingcar.domain;

import racingcar.constants.ExceptionMessages;

public class TryCount {
    private final int MINIMUM_INPUT = 1;
    private int tryCount;

    public TryCount(final int tryCount) {
        validateTryCount(tryCount);
        this.tryCount = tryCount;
    }

    private void validateTryCount(final int tryCount) {
        if (tryCount < MINIMUM_INPUT) {
            ExceptionMessages.INVALID_INPUT_ERROR_MESSAGE.throwException();
        }
    }

    public void decreaseCount() {
        tryCount--;
    }

    public boolean hasRepeat() {
        return tryCount >= MINIMUM_INPUT;
    }

    public int getTryCount() {
        return tryCount;
    }
}
