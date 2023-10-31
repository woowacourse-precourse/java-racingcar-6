package racingcar.model;

import java.util.List;

public class Race {
    private final List<Car> cars;

    public Race(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void runOneRound() {
        for (Car car : cars) {
            car.move();
        }
    }
}