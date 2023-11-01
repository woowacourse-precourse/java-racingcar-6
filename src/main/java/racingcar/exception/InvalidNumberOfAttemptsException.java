package racingcar.exception;

import racingcar.constants.ErrorMessage;

public class InvalidNumberOfAttemptsException extends IllegalArgumentException {
    public InvalidNumberOfAttemptsException() {
        throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_OF_ATTEMPTS);
    }
}
