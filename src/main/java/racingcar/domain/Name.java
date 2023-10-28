package racingcar.domain;

import java.util.Objects;
import racingcar.constant.ErrorMessage;

public final class Name {

    private static final int MAX_NAME_LENGTH = 5;
    private static final String BLANK = " ";
    private final String value;

    public Name(final String value) {
        validate(value);
        this.value = value;
    }

    private void validate(final String name) {
        if (isInvalidName(name)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME_LENGTH.toValue());
        }
    }

    private boolean isInvalidName(final String name) {
        return name.length() > MAX_NAME_LENGTH || name.startsWith(BLANK) || name.endsWith(BLANK);
    }

    public String toValue() {
        return this.value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Name name = (Name) o;
        return Objects.equals(value, name.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
