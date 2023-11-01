package racingcar.exception;


import static racingcar.constant.ExceptionMessage.INVALID_VALUE;

public class InvalidValueException extends IllegalArgumentException{
    public InvalidValueException() {
        super(INVALID_VALUE.getMessage());
    }
}
