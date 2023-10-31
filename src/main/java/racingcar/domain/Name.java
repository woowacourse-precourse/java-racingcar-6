package racingcar.domain;

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
            throw new IllegalArgumentException(NAME_BLANK_ERROR_MESSAGE);
        }
    }

    private void validateLength(final String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    private void validateContainBlank(final String name) {
        if (hasBlankInLeadingOrTrailing(name)) {
            throw new IllegalArgumentException(NAME_CONTAIN_BLANK_ERROR_MESSAGE);
        }
        if (hasBlankInMiddle(name)) {
            throw new IllegalArgumentException(NAME_CONTAIN_BLANK_ERROR_MESSAGE);
        }
    }

    private boolean hasBlankInLeadingOrTrailing(final String name) {
        return name.length() != name.strip().length();
    }

    private boolean hasBlankInMiddle(final String name) {
        return name.contains(WHITESPACE);
    }

    public String getName() {
        return name;
    }

}
