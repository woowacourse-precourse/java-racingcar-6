package racingcar.error.RacingCarDrivers;

import racingcar.error.ErrorMessage;

public class NameInputNullException extends IllegalArgumentException {

    public NameInputNullException(ErrorMessage message) {
        super(message.getMessage());
    }
}