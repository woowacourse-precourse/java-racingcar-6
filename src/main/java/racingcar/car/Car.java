package racingcar.car;

import racingcar.car.name.CarName;

public class Car {

    private final CarName carName;
    private int distanceDriven;

    public Car(CarName carName) {
        this.carName = carName;
        distanceDriven = 0;
    }
}
