package racingcar.service;

import java.util.List;
import racingcar.controller.Car;

public class Move {

    private RandomNumber randomNumber;
    private List<Car> cars;

    public Move(List<Car> cars) {
        this.randomNumber = new RandomNumber();
        this.cars = cars;
    }

    public void allCars() {
        for (Car car : cars) {
            if (randomNumber.generate() >= 4) {
                car.move();
            }

        }

    }
}
