package racingcar.domain.exception;

public class DomainConstraintsException extends IllegalArgumentException {
    private DomainConstraintsException(String message) {
        super(message);
    }

    public static DomainConstraintsException of(String message) {
        return new DomainConstraintsException(message);
    }
}