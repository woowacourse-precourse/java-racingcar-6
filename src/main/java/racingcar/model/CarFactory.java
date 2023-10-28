package racingcar.model;

import java.util.List;

public class CarFactory {

    public static List<Car> initCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .toList();
    }
}
