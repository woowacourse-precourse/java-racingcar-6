package racingcar.domain;

import racingcar.wrapper.CarName;
import racingcar.wrapper.CarPosition;

import static racingcar.domain.constant.CarConstant.CAR_FORWARD_NUMBER;

public class Car {
    
    private final CarName name;
    
    private final CarPosition position;

    private Car(final String name) {
        this.name = CarName.create(name);
        this.position = CarPosition.create();
    }

    private static Car create(final String name) {
        return new Car(name);
    }

    public void move(final int power) {
        if (power >= CAR_FORWARD_NUMBER.getValue()) {
            position.addPosition();
        }
    }

    public boolean isSamePosition(final Car diffCar) {
        return diffCar.getPosition() == position.getPosition();
    }

    public int getPosition() {
        return position.getPosition();
    }

    public String getName() {
        return name.getName();
    }
}
