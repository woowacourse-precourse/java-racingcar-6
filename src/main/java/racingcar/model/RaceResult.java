package racingcar.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RaceResult {

    private final List<Car> cars;

    public RaceResult(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> carsToList() {
        return Collections.unmodifiableList(cars);
    }

    public List<String> getWinners() {
        int maxDistance = getMaxDistance();
        return cars.stream()
            .filter(car -> car.getDistance() == maxDistance)
            .map(Car::getCarName)
            .collect(Collectors.toList());
    }

    private int getMaxDistance() {
        return cars.stream()
            .mapToInt(Car::getDistance)
            .max()
            .orElse(0);
    }

}
