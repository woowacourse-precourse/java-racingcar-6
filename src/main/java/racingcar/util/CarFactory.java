package racingcar.util;

import java.util.List;
import racingcar.domain.Car;

public class CarFactory {
    public static List<Car> createCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::new).toList();
    }
}
