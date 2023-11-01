package racingcar.common.exception;

public class CarException extends IllegalArgumentException {

    public CarException(ErrorMessage errorCode) {
        super(errorCode.getMessage());
    }
}
