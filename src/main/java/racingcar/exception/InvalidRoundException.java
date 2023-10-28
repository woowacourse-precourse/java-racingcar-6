package racingcar.exception;

public final class InvalidRoundException extends IllegalArgumentException {
    public static final String INVALID_ROUND_EXCEPTION = "최소 라운드 수는 1입니다";

    public InvalidRoundException() {
        super(INVALID_ROUND_EXCEPTION);
    }

}
