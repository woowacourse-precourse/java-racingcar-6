package racingcar.exception;

public abstract class CustomException extends IllegalArgumentException {
    public CustomException(String message) {
        super(message);
    }
}
