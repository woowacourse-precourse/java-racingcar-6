package racingcar;

import java.util.List;

public class Game {
    private final Cars cars;

    public Game(List<String> carNames) {
        this.cars = initCars(carNames);
    }

    private Cars initCars(List<String> carNames) {
        List<Car> carsWithName = createCarsWithName(carNames);
        return new Cars(carsWithName);
    }

    private List<Car> createCarsWithName(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .toList();
    }
}