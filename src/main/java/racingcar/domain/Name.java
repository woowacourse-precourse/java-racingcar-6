package racingcar.domain;

public class Name {
    public static final Integer NAME_VALIDATION_LENGTH = 5;
    private static final String NAME_LENGTH_EXCEPTION_MESSAGE = "4글자 이하의 이름을 입력하세요.";

    private final String name;

    public Name(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() >= NAME_VALIDATION_LENGTH) {
            throw new IllegalArgumentException(NAME_LENGTH_EXCEPTION_MESSAGE);
        }
    }

    public String getName() {
        return name;
    }
}