package racingcar.exception;

import static racingcar.exception.ExceptionConstant.DUPLICATED_CAR_NAME_EXCEPTION;

public class DuplicatedCarException extends IllegalArgumentException{
    public DuplicatedCarException() {
        super(DUPLICATED_CAR_NAME_EXCEPTION);
    }
}
