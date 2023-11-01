package racingcar.exception;

import racingcar.constant.ErrorMessage;

public class InvalidTryCountException extends IllegalArgumentException {

    public InvalidTryCountException() {
        super(ErrorMessage.INVALID_TRY_COUNT.getMessage());
    }
}
