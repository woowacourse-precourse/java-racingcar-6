package racingcar.exception;

import static racingcar.exception.ExceptionConstant.UNDER_RACING_CARS_NUM_MIN_EXCEPTION;

public class UnderCarMinNumException extends IllegalArgumentException{
    public UnderCarMinNumException() {
        super(UNDER_RACING_CARS_NUM_MIN_EXCEPTION);
    }
}
