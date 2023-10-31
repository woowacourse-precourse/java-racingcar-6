package racingcar.exception;

import racingcar.constant.ErrorMessage;

public class IllegalRacingStatusException extends IllegalStateException {

    public IllegalRacingStatusException() {
        super(ErrorMessage.INVALID_RACING_STATUS.getMessage());
    }
}
