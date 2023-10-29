package racingcar.exception;

public class NullException extends IllegalArgumentException{
    public static final String NullExceptionMessage = "null이 입력되었습니다.";
    public NullException() {
        super(NullExceptionMessage);
    }
}
