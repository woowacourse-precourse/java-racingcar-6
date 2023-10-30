package racingcar.exception;

public class UserInputIsNullException extends IllegalArgumentException {
    private static final String message = "입력값이 없습니다.";

    public UserInputIsNullException() {
        super(message);
    }
}
