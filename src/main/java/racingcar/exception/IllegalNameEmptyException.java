package racingcar.exception;

import racingcar.constant.ErrorMessages;

public class IllegalNameEmptyException extends IllegalArgumentException{
    public IllegalNameEmptyException() {
        super(ErrorMessages.NAME_INPUT_EMPTY_ERROR.getMessage());
    }
}
