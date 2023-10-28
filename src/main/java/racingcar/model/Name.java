package racingcar.model;

import java.util.Objects;
import racingcar.exception.InvalidNameException;

public class Name {

    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public Name(final String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(final String name) {
        if (isInvalidName(name)) {
            throw new InvalidNameException();
        }
    }

    private boolean isInvalidName(final String name) {
        return name.length() > MAX_NAME_LENGTH || name.isEmpty();
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

    public String getName() {
        return name;
    }
}
