package racingcar.exception.round;

public final class InvalidMaxRoundInputException extends IllegalArgumentException {
    public static final String INVALID_MAX_ROUND_INPUT_EXCEPTION_MESSAGE = "유효하지 않은 양식입니다.\n반드시 숫자를 입력해주세요.";

    public InvalidMaxRoundInputException() {
        super(INVALID_MAX_ROUND_INPUT_EXCEPTION_MESSAGE);
    }
}
