package racingcar.exception;

import static racingcar.exception.ExceptionConstant.NON_NULL_CAR_NAME_EXCEPTION;

public class NonNullCarNameException extends IllegalArgumentException{
    public NonNullCarNameException() {
        super(NON_NULL_CAR_NAME_EXCEPTION);
    }
}
