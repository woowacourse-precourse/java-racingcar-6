package racingcar.exception;

public class InvalidCountException extends IllegalArgumentException {
    public InvalidCountException(String message) {
        super(message);
    }
}