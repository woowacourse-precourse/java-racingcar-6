package racingcar.exception.count;

public class CountRangeException extends IllegalArgumentException {
    private static final String REQUEST_NON_NEGATIVE = "0이상 입력해주세요.";


    public CountRangeException() {
        super(REQUEST_NON_NEGATIVE);
    }
}
