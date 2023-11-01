package racingcar.utils;

public class RaceExecutionException extends RuntimeException {
    public RaceExecutionException(String message) {
        super(message);
    }
    public RaceExecutionException(String message, Throwable cause) {
        super(message, cause);
    }

}
