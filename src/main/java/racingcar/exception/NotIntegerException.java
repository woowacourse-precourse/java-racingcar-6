package racingcar.exception;

public class NotIntegerException extends IllegalStateException {
    public NotIntegerException() {
        super("숫자가 아닙니다.");
    }
}
