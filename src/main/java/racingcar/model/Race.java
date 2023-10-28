package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Race {

    private final List<Car> cars = new ArrayList<>();

    public void add(Car car) {
        cars.add(car);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public List<String> getCarNames() {
        return cars.stream()
                .map(Car::getName)
                .toList();
    }
}
