package racingcar.exception;

public class NonPositiveIntException extends IllegalArgumentException {

    private static final String POSITIVE_INT_INPUT_MESSAGE = "양의 정수가 아닙니다.";

    public NonPositiveIntException() {
        super(POSITIVE_INT_INPUT_MESSAGE);
    }
}
