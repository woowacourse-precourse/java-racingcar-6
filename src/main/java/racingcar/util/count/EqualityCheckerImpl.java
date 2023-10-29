package racingcar.util.count;

import java.util.Objects;
import racingcar.model.TryCount;

public class EqualityCheckerImpl implements EqualityChecker {
    private final int tryCount;

    private EqualityCheckerImpl(int tryCount) {
        this.tryCount = tryCount;
    }
    public static EqualityCheckerImpl createTryCount(int tryCount) {
        return new EqualityCheckerImpl(tryCount);
    }

    @Override
    public boolean countEquals(Object o) {
        isEqual(o);
        TryCount tryCount1 = (TryCount) o;
        return tryCount == tryCount1.tryCount;
    }

    public boolean isEqual(Object o) {
        if (this == o) {
            return true;
        }
        return false;
    }

    @Override
    public int generateHashCode() {
        return Objects.hash(tryCount);
    }

}


