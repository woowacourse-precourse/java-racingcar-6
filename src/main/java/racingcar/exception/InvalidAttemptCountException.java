package racingcar.exception;

public class InvalidAttemptCountException extends IllegalArgumentException {
    public InvalidAttemptCountException(String s) {
        super(s);
    }

    public InvalidAttemptCountException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidAttemptCountException(Throwable cause) {
        super(cause);
    }
}
