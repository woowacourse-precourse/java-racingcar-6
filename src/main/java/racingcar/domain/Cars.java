package racingcar.domain;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Collection<Car> getCars() {
        return Collections.unmodifiableCollection(cars);
    }
}
