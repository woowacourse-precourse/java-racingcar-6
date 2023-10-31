package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Referee {

    public int getFurthestDistance(List<Car> cars) {
        return cars.stream().mapToInt(Car::getDistance).max().orElseThrow(IllegalArgumentException::new);
    }

    public List<Car> getFurthestCar(List<Car> cars) {
        int furthestDistance = getFurthestDistance(cars);
        return cars.stream()
                .filter(car -> car.getDistance() == furthestDistance)
                .collect(Collectors.toList());
    }

    public List<String> getFurthestCarNames(List<Car> cars) {
        List<Car> furthestCars = getFurthestCar(cars);
        return furthestCars.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
