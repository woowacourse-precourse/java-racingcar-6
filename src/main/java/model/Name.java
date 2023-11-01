package model;

import static model.ErrorMessage.INVALID_NAME_LENGTH;

public class Name {

    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    private Name(final String name) {
        this.name = name;
    }

    public static Name from(final String value) {
        validateLength(value);
        return new Name(value);
    }

    private static void validateLength(final String value) {
        if (!isLengthValid(value)) {
            throw new IllegalArgumentException(INVALID_NAME_LENGTH.getMessage());
        }
    }

    private static boolean isLengthValid(final String value) {
        return value.length() <= MAX_NAME_LENGTH && !value.isEmpty();
    }

    public String getName() {
        return name;
    }
}
