package racingcar.exception;

import racingcar.constant.ErrorMessage;

public class RacingCarException extends IllegalArgumentException {
    public RacingCarException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
    }
}