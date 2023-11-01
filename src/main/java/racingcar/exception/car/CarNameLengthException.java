package racingcar.exception.car;

public class CarNameLengthException extends IllegalArgumentException {

    public CarNameLengthException(String message) {
        super(message);
    }
}
