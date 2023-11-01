package racingcar.model;

import racingcar.constant.Error;
import racingcar.util.Utils;

public class TryCount {

    private final int tryCount;

    public TryCount(String tryCount) {
        validateTryCount(tryCount);
        this.tryCount = Integer.parseInt(tryCount);
    }

    private void validateTryCount(String tryCount) {
        if (!Utils.isNaturalNumber(tryCount)) {
            throw new IllegalArgumentException(Error.INVALID_TRY_COUNT_ERROR.getMessage());
        }
    }

    public int getTryCount() {
        return tryCount;
    }
}
