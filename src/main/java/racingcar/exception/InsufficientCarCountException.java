package racingcar.exception;

public class InsufficientCarCountException extends IllegalArgumentException {
    public InsufficientCarCountException() {
        super("자동차는 2대 이상이어야 합니다.");
    }
}
