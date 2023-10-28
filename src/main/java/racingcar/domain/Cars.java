package racingcar.domain;

import java.util.List;
import java.util.function.Consumer;

public class Cars {
    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public void forEach(Consumer<Car> action) {
        for (Car car : cars) {
            action.accept(car);
        }
    }
}
