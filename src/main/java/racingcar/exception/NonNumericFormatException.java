package racingcar.exception;

public class NonNumericFormatException extends IllegalArgumentException {

    private static final String NON_NUMERIC_INPUT_MESSAGE = "숫자가 아닙니다.";

    public NonNumericFormatException() {
        super(NON_NUMERIC_INPUT_MESSAGE);
    }
}
