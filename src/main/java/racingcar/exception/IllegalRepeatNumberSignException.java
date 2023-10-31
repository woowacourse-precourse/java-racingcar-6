package racingcar.exception;

import racingcar.constant.ErrorMessages;

public class IllegalRepeatNumberSignException extends IllegalArgumentException{
    public IllegalRepeatNumberSignException(){
        super(ErrorMessages.REPEAT_NUMBER_MINUS_ERROR.getMessage());
    }
}
