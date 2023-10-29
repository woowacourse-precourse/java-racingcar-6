package racingcar.factory;

import java.util.List;

import racingcar.domain.Car;

public class CarFactory {
    public List<Car> createCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .toList();
    }
}
