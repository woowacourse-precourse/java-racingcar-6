package racingcar.domain;

import racingcar.constant.ErrorMessage;

public final class TryCount {

    private static final int MIN_VALUE = 1;
    private final Integer value;

    public TryCount(final int value) {
        validate(value);
        this.value = value;
    }

    private void validate(final int value) {
        if (value < MIN_VALUE) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TRY_COUNT.toValue());
        }
    }
}
