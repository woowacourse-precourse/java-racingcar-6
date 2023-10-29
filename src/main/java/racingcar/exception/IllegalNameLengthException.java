package racingcar.exception;

import racingcar.constant.ErrorMessages;

public class IllegalNameLengthException extends IllegalArgumentException{
    public IllegalNameLengthException() {
        super(ErrorMessages.NAME_INPUT_LENGTH_ERROR.getMessage());
    }
}
