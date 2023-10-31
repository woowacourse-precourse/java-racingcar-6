package racingcar.exception;

public class BaseException extends IllegalArgumentException {
    private static final String PREFIX = "[ERROR] ";

    public BaseException(String message) {
        super(PREFIX + message);
    }

}
