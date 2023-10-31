package racingcar.exception.car.carName;

public class HasSpaceException extends IllegalArgumentException {
    public static final String HAS_BLANK_EXCEPTION_MESSAGE = "공백이 포함되어 있습니다.";

    public HasSpaceException() {
        super(HAS_BLANK_EXCEPTION_MESSAGE);
    }
}
