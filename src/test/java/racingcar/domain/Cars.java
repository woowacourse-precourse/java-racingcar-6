package racingcar.domain;

import java.util.Collections;
import java.util.List;

public class Cars {

    private static final int STARTING_POSITION = 1;

    private final List<Car> cars;

    public Cars(List<String> names) {
        this.cars = createCars(names);
    }

    public static Cars of(List<String> names) {
        return new Cars(names);
    }

    private List<Car> createCars(List<String> names) {
        return names.stream()
                .map(name -> Car.of(name, STARTING_POSITION))
                .toList();
    }

    public List<Car> get() {
        return Collections.unmodifiableList(cars);
    }
}
