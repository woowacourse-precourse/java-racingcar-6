package racingcar.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Game {
    private final List<Car> cars;

    public Game(List<Car> cars) {
        assert !cars.isEmpty();

        this.cars = cars;
    }

    public void executeSingleCycleCarMove() {
        for(Car car : cars) {
            car.action();
        }
    }

    public Map<String, Integer> getCurrentGameResult() {
        Map<String, Integer> results = new HashMap<>();
        for (Car car : cars) {
            results.put(car.getName(), car.getPosition());
        }
        return results;
    }

    public List<String> getCurrentWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max().orElseThrow(NoSuchElementException::new);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
