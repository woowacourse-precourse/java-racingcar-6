package racingcar.exception.round;

public class NonPositiveIntegerException extends IllegalArgumentException{
    public static final String NonPositiveIntegerExceptionMessage = "양수를 입력하지 않았습니다.";
    public NonPositiveIntegerException() {
        super(NonPositiveIntegerExceptionMessage);
    }
}
