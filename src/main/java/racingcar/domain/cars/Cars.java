package racingcar.domain.cars;

import java.util.List;
import racingcar.domain.car.Car;

public abstract class Cars {

    protected final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> cars() {
        return cars;
    }
}
