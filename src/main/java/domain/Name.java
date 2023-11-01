package domain;

import ui.Output;

import java.util.Objects;
import java.util.regex.Pattern;

public class Name {
    private static final String CAR_NAME_FORMAT = "^[a-zA-Z0-9]*$";
    public static final int MIN_CAR_NAME_LENGTH = 1;
    public static final int MAX_CAR_NAME_LENGTH = 5;

    private final String name;

    public Name(String name) {
        isNull(name);
        isValidLength(name);
        isValidFormat(name);

        this.name = name;
    }

    private void isNull(String name) {
        if (Objects.isNull(name)) {
            throw new IllegalArgumentException(Output.NULL_EXCEPTION_MESSAGE);
        }
    }

    private void isValidLength(String name) {
        if (name.length() > MAX_CAR_NAME_LENGTH || name.length() < MIN_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(Output.CAR_NAME_LENGTH_EXCEPTION_MESSAGE);
        }
    }

    private void isValidFormat(String name) {
        if (!Pattern.matches(CAR_NAME_FORMAT, name)) {
            throw new IllegalArgumentException(Output.CAR_NAME_FORMAT_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Name compareName = (Name)o;
        return this.name.equals(compareName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }
}
