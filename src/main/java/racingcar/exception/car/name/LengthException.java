package racingcar.exception.car.name;

import static racingcar.constant.RacingGameConstants.CAR_NAME_LENGTH_MAX;
import static racingcar.constant.RacingGameConstants.CAR_NAME_LENGTH_MIN;

public class LengthException extends IllegalArgumentException {
    public static final String LENGTH_EXCEPTION_MESSAGE
            = String.format("이름은 %d자 이상 %d자 이하여야 합니다.", CAR_NAME_LENGTH_MIN, CAR_NAME_LENGTH_MAX);

    public LengthException() {
        super(LENGTH_EXCEPTION_MESSAGE);
    }
}
