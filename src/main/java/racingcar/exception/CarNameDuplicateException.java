package racingcar.exception;

public class CarNameDuplicateException extends IllegalArgumentException {
    public CarNameDuplicateException(String message) {
        super(message);
    }
}
