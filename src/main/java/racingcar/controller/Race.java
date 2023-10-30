package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.RandomNumber;

public class Race {
    private List<Car> racingCars;

    private Race(Cars racingCars) {
        this.racingCars = racingCars.getRacingCars();
    }

    public static Race createRace(Cars racingCars) {
        return new Race(racingCars);
    }

    public void run() {
        for (Car car : racingCars) {
            RandomNumber number = RandomNumber.makeRandomNumber();
            if (number.isMovable()) {
                car.move();
            }
            System.out.println(car.getStatusString());
        }
    }
}