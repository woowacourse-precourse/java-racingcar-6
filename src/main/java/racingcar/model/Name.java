package racingcar.model;

public class Name {
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;
    private static final String NAME_LENGTH_EXCEPTION_MESSAGE = String.format("이름은 %d~%d글자여야 합니다", MIN_NAME_LENGTH,
            MAX_NAME_LENGTH);

    private final String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        validateLength(name);
    }

    private void validateLength(String name) {
        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(NAME_LENGTH_EXCEPTION_MESSAGE);
        }
    }

    public String format() {
        return this.name;
    }

}
