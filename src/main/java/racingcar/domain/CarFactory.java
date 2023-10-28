package racingcar.domain;

import java.util.List;

public class CarFactory {
    public static Cars createCars(List<String> carNames) {
        List<Car> cars = carNames.stream()
                .map(Name::from)
                .map(Car::from)
                .toList();

        return Cars.from(cars);
    }
}