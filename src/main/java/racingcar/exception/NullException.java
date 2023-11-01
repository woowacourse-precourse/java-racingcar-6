package racingcar.exception;

public class NullException extends IllegalArgumentException {
    public static final String NULL_EXCEPTION_MESSAGE = "null이 입력되었습니다.";

    public NullException() {
        super(NULL_EXCEPTION_MESSAGE);
    }
}
