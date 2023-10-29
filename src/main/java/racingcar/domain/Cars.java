package racingcar.domain;

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

    public List<Car> rushCars() {
        cars.forEach(car -> {
            if (Judge.canRush()) {
                car.rush();
            }
        });
        return cars;
    }
}
