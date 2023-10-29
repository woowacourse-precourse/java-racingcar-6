package racingcar.exceptions.argument;

public class LessThanTryCountMinException extends IllegalArgumentException {

    private static final String LESS_THAN_TRY_COUNT_MIN_MESSAGE = "최소 시도 횟수 보다 작은 시도 횟수 입니다.";

    public LessThanTryCountMinException() {
        super(LESS_THAN_TRY_COUNT_MIN_MESSAGE);
    }
}
