package racingcar.domain;

public record Name(String name) {

    private static final int NAME_MAX_LENGTH = 5;
    private static final String INVALID_NAME_MESSAGE = "잘못된 이름을 입력하셨습니다.";

    public Name {
        validateName(name);
    }

    private void validateName(String name) {
        if (name.isBlank() || name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(INVALID_NAME_MESSAGE);
        }
    }
}
