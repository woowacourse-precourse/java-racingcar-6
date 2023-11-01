package racingcar.model;

import static racingcar.util.Constants.ZERO;

import racingcar.exception.CustomException;
import racingcar.util.count.EqualityCheckerImpl;

public class TryCount {
    public final int tryCount;
    private final EqualityCheckerImpl equalityChecker;

    public TryCount(String countString) {
        this.tryCount = convertStringToInt(countString);
        validatePositive(tryCount);
        this.equalityChecker = EqualityCheckerImpl.createTryCount(tryCount);
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

    public boolean isNotValid() {
        return tryCount == ZERO;
    }
}
