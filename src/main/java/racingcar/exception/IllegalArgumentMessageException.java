package racingcar.exception;

public class IllegalArgumentMessageException extends IllegalArgumentException {
    public IllegalArgumentMessageException(IllegalArgumentMessage exceptionMessage) {
        super(exceptionMessage.getMessage());
    }
}