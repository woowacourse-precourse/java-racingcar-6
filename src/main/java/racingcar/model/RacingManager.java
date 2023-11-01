package racingcar.model;

import racingcar.exception.ErrorCode;

public class RacingManager {
    private int tryCount;

    public RacingManager(int tryCount) {
        validateTryCount(tryCount);
        this.tryCount = tryCount;
    }

    public void countMove() {
        tryCount++;
    }

    public boolean canMove() {
        return tryCount > 0;
    }

    private void validateTryCount(int tryCount) {
        if (tryCount <= 0) {
            throw new IllegalArgumentException(ErrorCode.NON_POSITIVE_TRY_COUNT.getMessage());
        }
    }
}
