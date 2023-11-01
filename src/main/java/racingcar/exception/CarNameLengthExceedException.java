package racingcar.exception;

import static racingcar.constants.Integers.MAX_CAR_NAME_LENGTH;

public class CarNameLengthExceedException extends IllegalArgumentException {

    public static final String ERROR_MESSAGE = String.format("자동차의 이름의 길이는 %d를 초과해선 안됩니다.", MAX_CAR_NAME_LENGTH.show());

    public CarNameLengthExceedException() {
        super(ERROR_MESSAGE);
    }
}
