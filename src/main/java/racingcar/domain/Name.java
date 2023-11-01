package racingcar.domain;

public record Name(String value) {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String NAME_IS_REQUIRED = "이름은 필수값입니다.";
    private static final String NAME_LENGTH_IS_TOO_LONG = "이름은 5자 이하만 가능합니다.";

    public Name {
        validate(value);
    }

    private void validate(String value) {
        validateNonNullAndNonEmpty(value);
        validateLength(value);
    }

    private static void validateLength(String value) {
        if (value.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(NAME_LENGTH_IS_TOO_LONG);
        }
    }

    private static void validateNonNullAndNonEmpty(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException(NAME_IS_REQUIRED);
        }
    }

    @Override
    public String toString() {
        return value;
    }
}
