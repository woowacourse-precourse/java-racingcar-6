package racingcar.error.RacingCarDrivers;

import racingcar.error.ErrorMessage;

public class NameLengthExceededException extends IllegalArgumentException {

    public NameLengthExceededException(ErrorMessage message) {
        super(message.getMessage());
    }
}
