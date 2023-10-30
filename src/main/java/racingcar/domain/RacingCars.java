package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class RacingCars {

    private final List<Car> cars;

    public RacingCars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public Stream<Car> stream() {
        return this.cars.stream();
    }




}
