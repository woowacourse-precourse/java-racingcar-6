package racingcar.domain;

import java.util.Collections;
import java.util.List;

public class Navigation {

    private final List<Car> cars;

    public Navigation(List<Car> cars) {
        this.cars = cars;
    }

    public void moveAll() {
        for (Car car : getList()) {
            car.move();
        }
    }

    public List<Car> getList() {
        return Collections.unmodifiableList(cars);
    }
}
