package racingcar.domain.raingcar;

import racingcar.constant.Constant;
import racingcar.constant.ErrorMessage;

public class RacingCar {
    private String name;
    private Integer position;

    public RacingCar(String name) {
        verify(name);

        this.name = name;
        this.position = 0;
    }

    public void move() {
        this.position++;
    }
    public String getName() {
        return this.name;
    }
    public Integer getPosition() { return this.position; }

    private void verify(String name) {

        if (name.length() < Constant.CAR_NAME_MIN_SIZE || name.length() > Constant.CAR_NAME_MAX_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_LENGTH_ERROR);
        }

        if (name.matches(Constant.CAR_NAME_REGEX_EXPRESSION)) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_INVALID_CHARACTER_ERROR);
        }
    }
}