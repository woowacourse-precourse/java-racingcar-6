package racingcar.util.count;

import java.util.Objects;
import racingcar.model.TryCount;

public final class EqualityCheckerImpl implements EqualityChecker {
    private final int tryCount;

    private EqualityCheckerImpl(int tryCount) {
        this.tryCount = tryCount;
    }

    public static EqualityCheckerImpl createTryCount(int tryCount) {
        return new EqualityCheckerImpl(tryCount);
    }

    @Override
    public boolean countEquals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EqualityCheckerImpl that = (EqualityCheckerImpl) o;
        return tryCount == that.tryCount;
    }

    @Override
    public int generateHashCode() {
        return Objects.hash(tryCount);
    }
}


