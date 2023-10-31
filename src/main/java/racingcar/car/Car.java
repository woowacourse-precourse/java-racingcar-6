package racingcar.car;

import racingcar.car.name.CarName;

public class Car {

    private final CarName carName;
    private int distanceDriven;

    public Car(CarName carName) {
        this.carName = carName;
        distanceDriven = 0;
    }

    public void moveForward() {
        distanceDriven++;
    }

    public String getCarName() {
        return carName.name();
    }

    public int getDistanceDriven() {
        return distanceDriven;
    }
}
