package racingcar.exceptions.argument;

public class OverCarNameLengthLimitException extends IllegalArgumentException {

    private static final String OVER_CAR_NAME_LENGTH_LIMIT_MESSAGE = "자동차 이름은 5자 이하여야 합니다";

    public OverCarNameLengthLimitException() {
        super(OVER_CAR_NAME_LENGTH_LIMIT_MESSAGE);
    }
}
