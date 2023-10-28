package racingcar.model;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Race {

    private final Set<Car> cars = new LinkedHashSet<>();

    public void add(Car car) {
        cars.add(car);
    }

    public Set<Car> getCars() {
        return Collections.unmodifiableSet(cars);
    }

    public List<String> getCarNames() {
        return cars.stream()
                .map(Car::getName)
                .toList();
    }
}
