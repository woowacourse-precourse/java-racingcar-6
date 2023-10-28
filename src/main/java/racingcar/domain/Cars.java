package racingcar.domain;

import java.util.Collections;
import java.util.List;
import racingcar.utils.CustomCollections;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        validateNotEmpty(cars);
        this.cars = cars;
    }

    public static Cars from(List<Car> cars) {
        return new Cars(cars);
    }

    public List<Car> getCarsWithMaxStep() {
        return CustomCollections.maxAll(cars);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    private static void validateNotEmpty(List<Car> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
}
