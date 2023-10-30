package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public Stream<Car> stream() {
        return this.cars.stream();
    }




}
