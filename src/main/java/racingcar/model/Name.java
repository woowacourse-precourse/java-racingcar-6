package racingcar.model;

import static racingcar.view.exception.InputException.NAME_LENGTH_EXCEPTION;
import static racingcar.view.exception.InputException.NAME_VALUE_BLANK_EXCEPTION;

import java.util.Objects;

public class Name {

    private static final int MINIMUM_LENGTH = 1;
    private static final int MAXIMUM_LENGTH = 5;

    private final String name;

    private Name(final String name) {
        this.name = name;
    }

    public static Name from(final String name) {
        validateNameLengthIsCorrect(name);
        validateNameNotContainsBlank(name);
        return new Name(name);
    }

    private static void validateNameLengthIsCorrect(final String name) {
        if (name.length() < MINIMUM_LENGTH || name.length() > MAXIMUM_LENGTH) {
            throw new IllegalArgumentException(NAME_LENGTH_EXCEPTION.getMessage());
        }
    }

    private static void validateNameNotContainsBlank(final String name) {
        if (name.contains(" ")) {
            throw new IllegalArgumentException(NAME_VALUE_BLANK_EXCEPTION.getMessage());
        }
    }
    
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }

        if (other == null || getClass() != other.getClass()) {
            return false;
        }

        Name otherName = (Name) other;
        return Objects.equals(this.getName(), otherName.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
