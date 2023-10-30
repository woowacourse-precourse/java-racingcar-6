package racingcar;

import java.util.ArrayList;
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

    public void play() {
        cars.forEach(Car::conductAction);
    }
}
