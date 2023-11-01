package racingcar.exception;

import static racingcar.exception.ExceptionConstant.NON_POSITIVE_COUNT_EXCEPTION;

public class NonPositiveCountException extends IllegalArgumentException{
    public NonPositiveCountException() {
        super(NON_POSITIVE_COUNT_EXCEPTION);
    }
}
