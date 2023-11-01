package racingcar.exception;

public class CarNameLengthException extends IllegalArgumentException {
    public CarNameLengthException(String message) {
        super(message);
    }
}
