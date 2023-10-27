package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.CarGenerator;
import racingcar.domain.RandomNumber;
import racingcar.domain.RandomNumberGenerator;

public class Move {
    Car car = new Car();

    public void moveTheCar(String carname) {
        String moveValue = car.getCarList().get(carname);
        car.getCarList().put(carname, moveValue + "-");
    }

    public void stopTheCar(String carname) {
        String moveValue = car.getCarList().get(carname);
        car.getCarList().put(carname, moveValue + "");
    }
}
