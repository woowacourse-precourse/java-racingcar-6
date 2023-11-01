package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    public List<Car> cars;

    public Cars() {
    }

    public void add(Car car) {
        cars.add(car);
    }
}
