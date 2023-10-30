package racingcar.exception;

public class CarNameLengthExceedException extends IllegalArgumentException {

    public static final String ERROR_MESSAGE = "자동차의 이름의 길이는 5를 초과해선 안됩니다.";

    public CarNameLengthExceedException() {
        super(ERROR_MESSAGE);
    }
}
