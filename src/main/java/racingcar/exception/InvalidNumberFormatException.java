package racingcar.exception;

import static racingcar.exception.ExceptionConstant.INVALID_NUMBER_FORMAT_EXCEPTION;

public class InvalidNumberFormatException extends IllegalArgumentException{
    public InvalidNumberFormatException() {
        super(INVALID_NUMBER_FORMAT_EXCEPTION);
    }
}
