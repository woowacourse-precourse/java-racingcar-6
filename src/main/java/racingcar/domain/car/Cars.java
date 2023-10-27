package racingcar.domain.car;

import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        this.cars = List.copyOf(cars);
    }
}
