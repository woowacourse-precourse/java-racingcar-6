package racingcar.model;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Positions {

    private final List<Car> cars;

    public Positions(List<Car> cars) {
        this.cars = cars;
    }

    public int getPositionByName(String name) {
        return cars.stream()
                .filter(car -> car.getName().equals(name))
                .mapToInt(Car::getPosition)
                .findFirst()
                .orElseThrow();
    }

    public Set<String> getNames() {
        return cars.stream()
                .map(Car::getName)
                .collect(Collectors.toSet());
    }
}
