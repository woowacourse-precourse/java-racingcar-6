package racingcar.domain.car;

import racingcar.domain.car.validator.CarNameValidator;
import racingcar.utils.RandomNumber;

public class Car {

    private final String name;
    private int position;

    public Car(final String name) {
        CarNameValidator.validateCarName(name);
        this.name = name;
    }

    public void moveForward(final RandomNumber randomNumber) {
        if (randomNumber.isMovable()) {
            this.position++;
        }
    }

    public boolean isSamePosition(final int position) {
        return this.position == position;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }
}
