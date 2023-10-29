package racingcar.model;

import racingcar.utils.NumberGenerator;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class CarGroup {
    private final List<Car> cars;
    private NumberGenerator numberGenerator;

    public CarGroup(List<String> names, NumberGenerator numberGenerator) {
        this.cars = generateCars(names);
        this.numberGenerator = numberGenerator;
    }

    private List<Car> generateCars(List<String> names) {
        return names.stream()
                .map(Car::new)
                .collect(toList());
    }
}
