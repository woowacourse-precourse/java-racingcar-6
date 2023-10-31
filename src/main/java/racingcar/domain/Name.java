package racingcar.domain;

public class Name {
    private static final String LENGTH_ERROR_MESSAGE = "자동차 이름은 5글자 이하만 가능합니다.";
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public Name(String name) {
        validateLength(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validateLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(LENGTH_ERROR_MESSAGE);
        }
    }
}
