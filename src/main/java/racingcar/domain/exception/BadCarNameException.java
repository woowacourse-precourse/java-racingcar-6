package racingcar.domain.exception;

public class BadCarNameException extends IllegalArgumentException {
    public BadCarNameException() {
        super();
    }

    public BadCarNameException(String s) {
        super(s);
    }
}
