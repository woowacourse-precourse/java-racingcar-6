package racingcar.model;

import java.util.Objects;

public class Name {

    private static final int MAX_NAME_LENGTH = 5;
    private static final String INVALID_NAME_MESSAGE = "이름은 5자 이하여야 합니다.";

    private final String name;

    public Name(final String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(final String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_NAME_MESSAGE);
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Name otherName = (Name) o;
        return Objects.equals(name, otherName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
