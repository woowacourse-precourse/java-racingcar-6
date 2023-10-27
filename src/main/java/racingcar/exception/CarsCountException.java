package racingcar.exception;

public class CarsCountException extends IllegalArgumentException {
    public CarsCountException(String message) {
        super(message);
    }
}
