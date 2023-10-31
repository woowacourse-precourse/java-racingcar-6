package racingcar.exception;

public class NoExistCarException extends IllegalArgumentException {
    private static final String message = "자동차가 존재하지 않습니다.";

    public NoExistCarException() {
        super(message);
    }
}
