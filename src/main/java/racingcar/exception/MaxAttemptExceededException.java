package racingcar.exception;

public class MaxAttemptExceededException extends IllegalArgumentException {
    public MaxAttemptExceededException(String s) {
        super(s);
    }

    public MaxAttemptExceededException(String message, Throwable cause) {
        super(message, cause);
    }

    public MaxAttemptExceededException(Throwable cause) {
        super(cause);
    }
}
