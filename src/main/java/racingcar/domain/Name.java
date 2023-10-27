package racingcar.domain;

import racingcar.constant.ErrorMessage;

public final class Name {

    private static final int MAX_NAME_LENGTH = 5;
    private final String value;

    public Name(final String value) {
        validate(value);
        this.value = value;
    }

    private void validate(final String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME_LENGTH.toValue());
        }
    }

    public String toValue() {
        return this.value;
    }
}
