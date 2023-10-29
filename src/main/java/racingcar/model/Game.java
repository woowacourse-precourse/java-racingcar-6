package racingcar.model;

import java.util.List;

public class Game {

    private final List<Car> cars;

    public Game(List<Car> cars) {
        this.cars = cars;
    }

    private void run() {
        cars.forEach(this::attemptMoving);
    }

    private void attemptMoving(Car car) {
        if (checkMoving()) {
            car.move();
        }
    }

    private boolean checkMoving() {
        return true;
    }

}
