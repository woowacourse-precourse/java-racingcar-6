package racingcar.exception;

public class DuplicateNameException extends IllegalArgumentException {

    public DuplicateNameException(String s) {
        super(s);
    }

    public DuplicateNameException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicateNameException(Throwable cause) {
        super(cause);
    }
}
