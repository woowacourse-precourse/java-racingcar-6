package racingcar.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
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
            if (IsWinnerCondition(car)) {
                winnerNames.add(car.getName());
            }
        }
        return winnerNames;
    }

    private boolean IsWinnerCondition(Car car) {
        return car.getStatus() == getMaxScore() && car.getStatus() > 0;
    }

    private Integer getMaxScore() {
        return racingCars.stream().mapToInt(Car::getStatus).max().orElseThrow(NoSuchElementException::new);
    }
}