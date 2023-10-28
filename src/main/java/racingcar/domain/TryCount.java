package racingcar.domain;

import static racingcar.handler.ConstantsHandler.MIN_NUMBER;
import static racingcar.handler.ErrorHandler.INVALID_RANGE;

public class TryCount {

    private final int tryCount;

    public TryCount(int tryCount) {
        validateRange(tryCount);

        this.tryCount = tryCount;
    }

    public void validateRange(int tryCount) {
        if (tryCount < MIN_NUMBER) {
            throw INVALID_RANGE.getException();
        }
    }

    public int getTryCount() {
        return tryCount;
    }
}
