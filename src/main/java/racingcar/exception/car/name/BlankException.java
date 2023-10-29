package racingcar.exception.car.name;

import static racingcar.constant.RacingGameConstants.CAR_NAME_LENGTH_MAX;
import static racingcar.constant.RacingGameConstants.CAR_NAME_LENGTH_MIN;

public class BlankException extends IllegalArgumentException{
    public static final String BlankExceptionMessage = "공백이 포함되어 있습니다.";
    public BlankException() {
        super(BlankExceptionMessage);
    }
}
