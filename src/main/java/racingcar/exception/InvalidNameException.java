package racingcar.exception;

public class InvalidNameException extends IllegalArgumentException {
    public InvalidNameException(String s) {
        super(s);
    }

    public InvalidNameException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidNameException(Throwable cause) {
        super(cause);
    }
}
