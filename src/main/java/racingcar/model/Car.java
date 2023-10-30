package racingcar.model;

import racingcar.vo.CarName;
import racingcar.vo.CarPosition;

public class Car {

    private static final Integer START_POINT = 0;

    private final CarName carName;
    private CarPosition carPosition;

    protected Car(final CarName carName) {
        this.carName = carName;
        this.carPosition = new CarPosition(START_POINT);
    }

    public void updatePosition() {
        this.carPosition = new CarPosition(getCarPosition().position() + ActionType.randomAction());
    }

    public CarName getCarName() {
        return carName;
    }

    public CarPosition getCarPosition() {
        return carPosition;
    }
}
