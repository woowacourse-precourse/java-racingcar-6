package racingcar.model;

import java.util.Objects;

public final class TryCount {
    private static final String TRY_COUNT_RANGE_EXCEPTION_FORMAT = "시도 횟수는 %d 이상 %d 이하의 정수만 가능합니다.";
    private static final int MINIMUM_COUNT = 1;
    private static final int MAXIMUM_COUNT = 20;

    private final int count;

    private TryCount(int count) {
        validateCountRange(count);
        this.count = count;
    }

    private void validateCountRange(int count) {
        if (isOutOfRange(count)) {
            String exceptionMessage = String.format(TRY_COUNT_RANGE_EXCEPTION_FORMAT, MINIMUM_COUNT, MAXIMUM_COUNT);
            throw new IllegalArgumentException(exceptionMessage);
        }
    }

    private boolean isOutOfRange(int count) {
        return count < MINIMUM_COUNT || count > MAXIMUM_COUNT;
    }

    public static TryCount from(int count) {
        return new TryCount(count);
    }

    public int getCount() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TryCount tryCount = (TryCount) o;
        return count == tryCount.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }
}
