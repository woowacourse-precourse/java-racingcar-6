package racingcar.exception;

public class CarException extends IllegalArgumentException {

    public CarException(ErrorMessage errorCode) {
        super(errorCode.getMessage());
    }
}
