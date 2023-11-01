package racingcar.domain;

import java.util.Objects;

public class Name {

    private static final String NAME_RANGE_EXCEPTION_MESSAGE = " 이름은 5자 이하만 가능합니다.";
    private static final int NAME_MAX_LENGTH = 5;
    private static final int NAME_MIN_LENGTH = 1;
    private final String value;

    public Name(String name) {
        validateLengthOf(name);
        this.value = name;
    }

    private void validateLengthOf(String name) {
        if (name.length() > NAME_MAX_LENGTH || name.length() < NAME_MIN_LENGTH) {
            throw new IllegalArgumentException(NAME_RANGE_EXCEPTION_MESSAGE);
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
        Name name = (Name) o;
        return Objects.equals(value, name.value);
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
