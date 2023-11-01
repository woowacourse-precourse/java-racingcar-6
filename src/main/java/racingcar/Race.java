package racingcar;

import java.util.Arrays;
import java.util.List;

public class Race {

    private final List<Car> cars;

    public Race(String... carNames) {
        this.cars = Arrays.stream(carNames)
            .map(Car::of)
            .toList();
    }

    public void start() {
        cars.forEach(Car::move);
    }

    public List<Car> getWinners() {
        int maxPosition = cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElseThrow(IllegalArgumentException::new);

        return cars.stream()
            .filter(car -> car.getPosition() == maxPosition)
            .toList();
    }

    public List<Car> getCars() {
        return cars;
    }
}
