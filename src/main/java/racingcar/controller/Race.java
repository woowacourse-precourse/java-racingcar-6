package racingcar.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
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

    public List<String> getWinners() {
        List<String> winnerNames = new ArrayList<>();
        for (Car car : racingCars) {
            if (car.getStatus() == getMaxScore()) {
                winnerNames.add(car.getName());
            }
        }
        return winnerNames;
    }

    private Integer getMaxScore() {
        return racingCars.stream().mapToInt(Car::getStatus).max().orElseThrow(NoSuchElementException::new);
    }
}