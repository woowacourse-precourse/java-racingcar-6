package racingcar.domain;

import racingcar.constant.ErrorMessage;

public final class TryCount {

    private static final int MIN_VALUE = 1;
    private static final int NONE_LEFT = 0;
    private static final int MINUS_UNIT = 1;
    private final Integer value;

    public TryCount(final int value) {
        validate(value);
        this.value = value;
    }

    private TryCount(final TryCount tryCount) {
        this.value = tryCount.value - MINUS_UNIT;
    }

    private void validate(final int value) {
        if (value < MIN_VALUE) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TRY_COUNT.toValue());
        }
    }

    public boolean hasLeftCount() {
        return value > NONE_LEFT;
    }

    public TryCount next() {
        validatePositive();
        return new TryCount(this);
    }

    private void validatePositive() {
        if (value <= NONE_LEFT) {
            throw new IllegalStateException(ErrorMessage.NO_LEFT_TRY_COUNT.toValue());
        }
    }
}
