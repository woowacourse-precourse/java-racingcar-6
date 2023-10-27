package racingcar.model;

import java.util.List;
import racingcar.util.NumberGenerator;

public class Cars {

    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public void move(final NumberGenerator generator) {
        cars.forEach(car -> car.move(generator));
    }
}
