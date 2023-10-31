package racingcar.exception;

import static racingcar.constant.ExceptionMessage.LENGTH_EXCEED;

public class LengthExceedException extends IllegalArgumentException {

    public LengthExceedException() {
        super(LENGTH_EXCEED.getMessage());
    }
}
