package racingcar.model;

import racingcar.exception.CustomException;
import racingcar.util.count.EqualityCheckerImpl;

public class TryCount {
    public final int tryCount;

    public TryCount(String countString) {
        this.tryCount = convertStringToInt(countString);
        validatePositive(tryCount);
        EqualityCheckerImpl.createTryCount(tryCount);
    }

    private int convertStringToInt(String string) {
        return Integer.parseInt(string);
    }

    public boolean isNotSame(int tryCount) {
        return this.tryCount != tryCount;
    }

    private void validatePositive(int tryCount) {
        CustomException.positiveValidator(tryCount);
    }
}
