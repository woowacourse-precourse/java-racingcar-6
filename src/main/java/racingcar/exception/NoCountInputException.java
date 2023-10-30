package racingcar.exception;

public class NoCountInputException extends IllegalArgumentException {
    private static final String REQUEST_COUNT_INPUT_MESSAGE = "횟수를 입력하세요.";

    public NoCountInputException() {
        super(REQUEST_COUNT_INPUT_MESSAGE);
    }
}
