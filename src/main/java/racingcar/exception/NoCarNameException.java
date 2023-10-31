package racingcar.exception;

public class NoCarNameException extends IllegalArgumentException {
    private static final String message = "자동차 이름이 입력되지 않았습니다.";

    public NoCarNameException() {
        super(message);
    }
}
