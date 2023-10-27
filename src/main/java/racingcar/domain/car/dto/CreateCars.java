package racingcar.domain.car.dto;

import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;

public record CreateCars(List<String> carNames) {
    public Cars into() {
        final List<Car> cars = carNames.stream()
                .map(Car::new)
                .toList();
        return Cars.from(cars);
    }
}
