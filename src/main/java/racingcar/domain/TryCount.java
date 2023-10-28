package racingcar.domain;

import racingcar.constants.ExceptionMessage;

public class TryCount {

    private int tryCount;

    public TryCount(final int tryCount) {
        validateTryCount(tryCount);
        this.tryCount = tryCount;
    }

    private void validateTryCount(final int tryCount) {
        if (tryCount < 1) {
            ExceptionMessage.INVALID_INPUT_ERROR_MESSAGE.throwException();
        }
    }

    public void decreaseCount() {
        tryCount--;
    }

    public boolean hasRepeat() {
        return tryCount >= 1;
    }
}
