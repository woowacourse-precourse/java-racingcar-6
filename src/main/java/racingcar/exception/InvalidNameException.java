package racingcar.exception;

public class InvalidNameException extends IllegalArgumentException {

    private static final String INVALID_NAME_MESSAGE = "이름은 1글자 이상 5자 이하여야 합니다.";

    public InvalidNameException() {
        super(INVALID_NAME_MESSAGE);
    }
}
