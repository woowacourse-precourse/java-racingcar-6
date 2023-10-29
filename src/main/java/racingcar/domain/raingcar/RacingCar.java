package racingcar.domain.raingcar;

import racingcar.constant.Constant;
import racingcar.constant.ErrorMessage;

public class RacingCar {
    private final String name;
    private Integer move;

    public RacingCar(String name) {
        verify(name);
        this.name = name;
    }

    private void verify(String name) {

        if (name.length() < Constant.CAR_NAME_MIN_SIZE || name.length() > Constant.CAR_NAME_MAX_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_LENGTH_ERROR);
        }

        if (name.matches(Constant.CAR_NAME_REGEX_EXPRESSION)) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_INVALID_CHARACTER_ERROR);
        }
    }
}
