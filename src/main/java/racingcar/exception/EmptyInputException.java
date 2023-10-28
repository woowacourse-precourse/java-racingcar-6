package racingcar.exception;

public class EmptyInputException extends IllegalArgumentException {

    private static final String EMPTY_INPUT_MESSAGE = "입력이 비어 있습니다.";

    public EmptyInputException() {
        super(EMPTY_INPUT_MESSAGE);
    }
}
