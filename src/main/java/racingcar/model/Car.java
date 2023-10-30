package racingcar.model;

import racingcar.vo.CarDistance;
import racingcar.vo.CarName;

public class Car {

    private static final Integer START_POINT = 0;

    private final CarName carName;
    private CarDistance carDistance;

    public Car(final CarName carName) {
        this.carName = carName;
        this.carDistance = new CarDistance(START_POINT);
    }

    public void updateDistance() {
        this.carDistance = new CarDistance(getCarDistance().distance() + ActionType.randomAction());
    }

    public CarName getCarName() {
        return carName;
    }

    public CarDistance getCarDistance() {
        return carDistance;
    }
}
