package racingcar.domain.exception;

public class DuplicateCarNameException extends IllegalArgumentException {
    public DuplicateCarNameException() {
        super();
    }

    public DuplicateCarNameException(String s) {
        super(s);
    }
}
