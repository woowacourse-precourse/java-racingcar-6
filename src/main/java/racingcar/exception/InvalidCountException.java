package racingcar.exception;

public class InvalidCountException extends IllegalArgumentException {
    public InvalidCountException() {
        super("숫자를 입력해 주세요.");
    }

    public InvalidCountException(String message) {
        super(message);
    }
}