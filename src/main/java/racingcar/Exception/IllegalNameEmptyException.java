package racingcar.Exception;

import racingcar.Constant.ErrorMessages;

public class IllegalNameEmptyException extends IllegalArgumentException{
    public IllegalNameEmptyException() {
        super(ErrorMessages.NAME_INPUT_EMPTY_ERROR.getMessage());
    }
}
