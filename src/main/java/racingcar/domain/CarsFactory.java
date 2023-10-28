package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarsFactory {
    private final List<Car> cars = new ArrayList<>();

    public List<Car> getCars() {
        return cars;
    }

}
