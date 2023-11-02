package racingcar.model;

import racingcar.util.RandomNumber;

public class CarControlManager {
    public void moveFowardCar(Car car) {
        int randomValue = RandomNumber.pickRandomNumber();
        if (randomValue >= 4) {
            car.moveFowardCar();
        }
    }
}
