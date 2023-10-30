package racingcar.domain;

import java.util.List;

public class CarFactory {
    private CarFactory() {
    }

    public static Cars createCarsFromNames(List<String> carNames) {
        List<Car> cars = carNames.stream()
                .map(Name::from)
                .map(Car::from)
                .toList();

        return Cars.from(cars);
    }
}