package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class RaceResult {

    private final Cars cars;

    public RaceResult(Cars cars) {
        this.cars = cars;
    }

    public List<Car> carsToList() {
        return cars.toList();
    }

    public List<String> getWinners() {
        int maxDistance = cars.getMaxDistance();
        return cars.toList().stream()
            .filter(car -> car.distance() == maxDistance)
            .map(Car::carName)
            .collect(Collectors.toList());
    }


}
