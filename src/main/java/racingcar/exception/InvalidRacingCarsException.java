package racingcar.exception;

import racingcar.constants.ErrorMessage;

public class InvalidRacingCarsException extends IllegalArgumentException {
    public InvalidRacingCarsException() {
        throw new IllegalArgumentException(ErrorMessage.INVALID_RACING_CARS);
    }
}
