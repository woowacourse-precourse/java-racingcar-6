package racingcar.exception;

import racingcar.constants.ErrorMessage;

public class InvalidRacingCarsException extends IllegalArgumentException {
    public InvalidRacingCarsException() {
        super(ErrorMessage.INVALID_RACING_CARS);
    }
}
