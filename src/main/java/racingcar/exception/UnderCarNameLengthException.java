package racingcar.exception;

import static racingcar.exception.ExceptionConstant.UNDER_CAR_NAME_LENGTH;

public class UnderCarNameLengthException extends IllegalArgumentException{
    public UnderCarNameLengthException() {
        super(UNDER_CAR_NAME_LENGTH);
    }
}
