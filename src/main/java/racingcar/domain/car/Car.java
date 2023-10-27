package racingcar.domain.car;

import racingcar.domain.car.carcomponent.carposition.CarPosition;
import racingcar.domain.car.carcomponent.carposition.CarPositionCompareResult;

public class Car {
    private final String carName;
    private CarPosition carPosition;

    public Car(String carName) {
        this.carName = carName;
        this.carPosition = new CarPosition(0);
    }

    protected void move(boolean moveOrNot) {
        if (moveOrNot) {
            this.carPosition = carPosition.move();
        }
    }

    protected CarPositionCompareResult comparePosition(Car otherCar) {
        return this.carPosition.compare(otherCar.carPosition);
    }

    protected String getCarName() {
        return carName;
    }

    protected String makeMoveResultMessage() {
        return carName
                + " : "
                + carPosition.makePositionResultMessage();
    }
}
