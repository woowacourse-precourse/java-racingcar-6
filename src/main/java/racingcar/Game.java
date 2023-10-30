package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {
    private final List<Car> cars;

    public Game() {
        this.cars = new ArrayList<>();
    }

    public void saveCars(List<String> carNames) {
        carNames.stream()
                .map(carName -> new Car(carName, 0))
                .forEach(cars::add);
    }

    public List<Car> playOnce() {
        cars.forEach(Car::conductAction);
        return Collections.unmodifiableList(cars);
    }
}
