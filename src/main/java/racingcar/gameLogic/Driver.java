package racingcar.gameLogic;

import racingcar.models.Car;

public class Driver {
    Car car = new Car();

    public Driver(String carName) {
        car.setCarName(carName);
    }
}
