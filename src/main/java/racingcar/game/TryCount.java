package racingcar.game;

import java.util.Objects;

public class TryCount {
    public static final String INVALID_NUMBER_FORMAT_MESSAGE = "숫자만 입력할 수 있습니다.";
    public static final String INVALID_COUNT_MESSAGE = "시도 횟수는 0보다 커야 합니다.";
    public static final int FINISH_COUNT = 0;

    private int tryCount;

    public TryCount(String tryCount) {
        validate(tryCount);
        this.tryCount = toInteger(tryCount);
    }

    private void validate(String tryCount) {
        validateZero(toInteger(tryCount));
    }

    private void validateZero(int tryCount) {
        if (tryCount == FINISH_COUNT) {
            throw new IllegalArgumentException(INVALID_COUNT_MESSAGE);
        }
    }

    private int toInteger(String tryCount) {
        try {
            return Integer.parseInt(tryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT_MESSAGE, e);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TryCount tryCount1 = (TryCount) o;
        return tryCount == tryCount1.tryCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tryCount);
    }
}
