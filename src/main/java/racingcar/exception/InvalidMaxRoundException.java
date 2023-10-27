package racingcar.exception;

public final class InvalidMaxRoundException extends IllegalArgumentException {
    public static final String INVALID_MAX_ROUND_EXCEPTION = "최소 라운드 수는 1입니다";

    public InvalidMaxRoundException() {
        super(INVALID_MAX_ROUND_EXCEPTION);
    }

}
