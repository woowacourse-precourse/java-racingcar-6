package racingcar.gameLogic;

import racingcar.models.Car;
import racingcar.utils.RandomNumbers;

public class Driver {
    Car car = new Car();

    public Driver(String carName) {
        car.setCarName(carName);
    }

    public String sayCarName() {
        return car.getCarName();
    }

    private int requestRandomNumber() {
        return RandomNumbers.generateZeroToNineDigit();
    }
}
