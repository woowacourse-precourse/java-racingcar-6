package racingcar.domain;

import racingcar.constant.ExceptionMessage;

import java.util.Objects;

public class Name {

    private static final int MAX_LENGTH = 5;
    private final String value;

    public Name(String value) {
        validateLength(value);
        this.value = value;
    }

    private void validateLength(String value) {
        if (value.length() > MAX_LENGTH) {
            ExceptionMessage exceptionMessage = ExceptionMessage.TOO_LONG_NAME_LENGTH;
            throw new IllegalArgumentException(exceptionMessage.getMessage());
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Name name = (Name) obj;
        return this.value.equals(name.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value;
    }
}
