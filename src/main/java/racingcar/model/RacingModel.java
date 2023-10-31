package racingcar.model;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RacingModel {

    private final List<Car> racingCars;

    public RacingModel(List<Car> racingCars) {
        this.racingCars = racingCars;
    }

    private void moveCar() {
        racingCars.forEach(Car::move);
    }

    public List<String> getWinner() {
        return racingCars.stream().filter(car -> car.getPosition() == getMaxMoveDistance()).map(Car::getName).toList();
    }

    private int getMaxMoveDistance() {
        return Collections.max(racingCars, Comparator.comparingInt(Car::getPosition)).getPosition();
    }

    public List<Car> playRound() {
        moveCar();
        return racingCars;
    }
}
