package racingcar.domain;

import racingcar.validate.TryCountValidate;

public class TryCount {
    private final int tryCount;

    public TryCount(String tryCount) {
        TryCountValidate.validateTryCount(tryCount);
        this.tryCount = Integer.parseInt(tryCount);
    }

    public int getTryCount() {
        return tryCount;
    }
}
