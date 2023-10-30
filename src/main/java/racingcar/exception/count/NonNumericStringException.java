package racingcar.exception.count;

public class NonNumericStringException extends IllegalArgumentException {
    private static final String ONLY_NUMBER_INPUT_MESSAGE = "숫자만 입력하세요.";

    public NonNumericStringException() {
        super(ONLY_NUMBER_INPUT_MESSAGE);
    }
}
