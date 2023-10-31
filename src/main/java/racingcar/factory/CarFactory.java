package racingcar.factory;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;

public class CarFactory {
    public Cars createCars(List<String> carNames) {
        List<Car> cars = carNames.stream()
                .map(Car::new)
                .toList();
        return new Cars(cars);
    }
}
