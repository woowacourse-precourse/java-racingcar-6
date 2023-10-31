package racingcar.domain;

public class Name {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String LENGTH_EXCEPTION = "이름은 5자 이하여야 합니다.";
    private static final String NULL_EXCEPTION = "이름은 null 일 수 없습니다.";

    private final String name;

    public Name(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        validateNull(name);
        validateLength(name);
    }

    private void validateLength(String input) {
        if (input.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(LENGTH_EXCEPTION);
        }
    }

    private void validateNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException(NULL_EXCEPTION);
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
