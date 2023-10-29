package racingcar.domain.raingcar;

import racingcar.constant.Constant;
import racingcar.constant.ErrorMessage;
import racingcar.util.RandomNumberGenerator;

public class RacingCar {
    private final String name;
    private Integer position;

    public RacingCar(String name) {
        verify(name);
        this.name = name;
        this.position = 0;
    }

    public void move() {
        int randomNumber = RandomNumberGenerator.pick();
        if(moveForward(randomNumber)) position += randomNumber;
    }

    public Integer getPosition() {
        return position;
    }

    private boolean moveForward(final int number) {
        return number >= 4;
    }

    private void verify(final String name) {

        if (name.length() < Constant.CAR_NAME_MIN_SIZE || name.length() > Constant.CAR_NAME_MAX_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_LENGTH_ERROR);
        }

        if (name.matches(Constant.CAR_NAME_REGEX_EXPRESSION)) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_INVALID_CHARACTER_ERROR);
        }
    }
}
