package racingcar.entity.car;

import java.util.List;
import java.util.stream.Stream;

public class RaceCars {
    private final List<Car> cars;

    public RaceCars(List<Car> cars) {
        this.cars = cars;
    }

    public int size(){
        return cars.size();
    }

    public Stream<Car> stream(){
        return cars.stream();
    }

}
