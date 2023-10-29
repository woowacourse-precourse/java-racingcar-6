package racingcar.factory;

import racingcar.domain.Car;

import java.util.List;

public class CarFactory {
    public List<Car> createCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .toList();
    }
}
