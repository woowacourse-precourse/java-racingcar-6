package racingcar.exception;

public class InvalidNameException extends IllegalArgumentException {
    public InvalidNameException() {
        super("유효한 이름을 입력해 주세요.");
    }

    public InvalidNameException(String message) {
        super(message);
    }
}