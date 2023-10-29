package racingcar.domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    public void insertCarsNames(List<String> names) {
        this.cars = namesToCars(names);
    }

    private List<Car> namesToCars(List<String> names) {
        return names.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public List<Car> getCarsOrderByLocations() {
        return cars.stream()
                .sorted(Comparator.comparingInt(Car::getLocation).reversed())
                .collect(Collectors.toList());
    }
}
