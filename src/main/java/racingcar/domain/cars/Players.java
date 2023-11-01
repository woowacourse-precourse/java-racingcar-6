package racingcar.domain.cars;

import java.util.List;
import racingcar.domain.car.Car;

public class Players extends Cars {

    public Players(List<Car> cars) {
        super(cars);
    }

    public static Players of(List<String> names) {
        List<Car> cars = names.stream()
            .map(Car::new)
            .toList();
        return new Players(cars);
    }

    public void moveAll() {
        cars.forEach(Car::move);
    }
}
