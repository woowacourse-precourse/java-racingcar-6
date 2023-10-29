package racingcar.model;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class CarGroup {
    private final List<Car> cars;

    public CarGroup(List<String> names) {
        this.cars = generateCars(names);
    }

    private List<Car> generateCars(List<String> names) {
        return names.stream()
                .map(Car::new)
                .collect(toList());
    }
}
