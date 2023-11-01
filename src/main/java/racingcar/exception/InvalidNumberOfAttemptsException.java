package racingcar.exception;

import racingcar.constants.ErrorMessage;

public class InvalidNumberOfAttemptsException extends IllegalArgumentException {
    public InvalidNumberOfAttemptsException() {
        super(ErrorMessage.INVALID_NUMBER_OF_ATTEMPTS);
    }
}
