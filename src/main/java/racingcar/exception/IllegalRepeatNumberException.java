package racingcar.exception;

import racingcar.constant.ErrorMessages;

public class IllegalRepeatNumberException extends IllegalArgumentException{
    public IllegalRepeatNumberException(){
        super(ErrorMessages.REPEAT_NUMBER_INPUT_ERROR.getMessage());
    }
}
