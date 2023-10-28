package model;

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
            throw new IllegalArgumentException();
        }
    }

    private static boolean isLengthValid(final String value) {
        return value.length() <= MAX_NAME_LENGTH && !value.isEmpty();
    }

    @Override
    public boolean equals(final Object value) {
        if (value == name) {
            return true;
        }

        if (!(value instanceof Name nameValue)) {
            return false;
        }

        return name.equals(nameValue.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
