package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars createCars(List<Car> cars) {
        return new Cars(cars);
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> findWinners() {
        int maxLocation = cars.stream().mapToInt(Car::getCurrentLocation).max().orElse(0);
        return cars.stream()
                .filter(car -> car.getCurrentLocation() == maxLocation)
                .collect(Collectors.toList());
    }
}
