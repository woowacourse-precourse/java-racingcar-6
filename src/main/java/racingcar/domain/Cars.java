package racingcar.domain;

import java.util.List;

public record Cars(List<Car> cars) {

    public Cars(final List<Car> cars) {
        this.cars = List.copyOf(cars);
    }
}