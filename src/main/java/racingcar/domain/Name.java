package racingcar.domain;

import java.util.Objects;

public class Name {

    private static final int MAX_NAME_LENGTH = 5;
    private static final String WHITESPACE = " ";
    private static final String NAME_BLANK_ERROR_MESSAGE = "이름이 존재하지 않습니다.";
    private static final String NAME_LENGTH_ERROR_MESSAGE = "이름은 5자 이하만 가능합니다.";
    private static final String NAME_CONTAIN_BLANK_ERROR_MESSAGE = "이름에 공백이 존재하면 안됩니다.";

    private final String name;

    public Name(final String name) {
        validate(name);
        this.name = name;
    }

    private void validate(final String name) {
        validateBlank(name);
        validateLength(name);
        validateContainBlank(name);
    }

    private void validateBlank(final String name) {
        if (name.isBlank()) {
            throwException(NAME_BLANK_ERROR_MESSAGE);
        }
    }

    private void validateLength(final String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throwException(NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    private void validateContainBlank(final String name) {
        if (hasBlankInLeadingOrTrailing(name)) {
            throwException(NAME_CONTAIN_BLANK_ERROR_MESSAGE);
        }
        if (hasBlankInMiddle(name)) {
            throwException(NAME_CONTAIN_BLANK_ERROR_MESSAGE);
        }
    }

    private boolean hasBlankInLeadingOrTrailing(final String name) {
        return name.length() != name.strip().length();
    }

    private boolean hasBlankInMiddle(final String name) {
        return name.contains(WHITESPACE);
    }

    private void throwException(final String errorMessage) {
        throw new IllegalArgumentException(errorMessage);
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Name name1 = (Name) o;
        return Objects.equals(getName(), name1.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

}
