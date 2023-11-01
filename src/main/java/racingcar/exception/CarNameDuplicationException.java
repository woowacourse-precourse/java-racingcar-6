package racingcar.exception;

import static racingcar.constants.Integers.MAX_CAR_NAME_LENGTH;

public class CarNameDuplicationException extends IllegalArgumentException {

    public static final String ERROR_MESSAGE = "경주에 참여하는 자동차들의 이름 중 중복된 것이 있어선 안됩니다.";

    public CarNameDuplicationException() {
        super(ERROR_MESSAGE);
    }
}