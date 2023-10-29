package racingcar.domain;

import racingcar.Error;

public class TryCount {

    private final int tryCount;

    public TryCount(String tryCount) {
        validateTryCount(tryCount);
        this.tryCount = Integer.parseInt(tryCount);
    }

    public int getTryCount() {
        return tryCount;
    }

    private void validateTryCount(String tryCount) {
        if (!Utils.isNaturalNumber(tryCount)) {
            throw new IllegalArgumentException(Error.INVALID_TRY_COUNT_ERROR.getMessage());
        }
    }
}
