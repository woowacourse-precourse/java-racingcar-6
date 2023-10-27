package racingcar.domain.car;

import racingcar.domain.car.carcomponent.CarPosition;
import racingcar.domain.car.carcomponent.CarPositionCompareResult;

public class Car {
    private final String carName;
    private CarPosition carPosition;

    public Car(String carName) {
        this.carName = carName;
        this.carPosition = new CarPosition(0);
    }

    public void move(boolean moveOrNot) {
        if (moveOrNot) {
            this.carPosition = carPosition.move();
        }
    }

    public CarPositionCompareResult comparePosition(Car otherCar) {
        return this.carPosition.compare(otherCar.carPosition);
    }

    public String getCarName() {
        return carName;
    }

    @Override
    public String toString() {
        return carName
                + " : "
                + carPosition.makePositionResultMessage();
    }
}
