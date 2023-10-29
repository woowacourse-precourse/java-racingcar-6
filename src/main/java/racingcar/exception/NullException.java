package racingcar.exception;

public class NullException extends IllegalArgumentException{
    public NullException() {
        super("null이 입력되었습니다.");
    }
}
