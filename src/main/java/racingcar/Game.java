package racingcar;

import java.util.List;

public class Game {
    private final Cars cars;

    public Game(List<String> carNames) {
        this.cars = initCars(carNames);
    }

    public RoundResult race() {
        cars.race();
        return new RoundResult(cars.getCarDtos());
    }

    public List<Car> getWinners() {
        return cars.findWinners();
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