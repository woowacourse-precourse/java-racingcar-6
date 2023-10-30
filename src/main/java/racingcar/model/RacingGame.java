package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<Car> cars;

    public RacingGame(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }
}
