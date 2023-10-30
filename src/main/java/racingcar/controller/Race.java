package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.RandomNumber;

public class Race {
    private List<Car> racingCars;

    public Race(List<Car> racingCarList) {
        this.racingCars = racingCarList;
    }

    public void run() {
        for (Car car : racingCars) {
            RandomNumber number = RandomNumber.makeRandomNumber();
            if (number.isMovable()) {
                car.move();
            }
            System.out.println(car.getStatus());
        }
    }
}