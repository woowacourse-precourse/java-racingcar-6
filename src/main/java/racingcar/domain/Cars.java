package racingcar.domain;

import java.util.List;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Cars from(List<String> carNames) {
        List<Car> cars = mapToCars(carNames);
        return new Cars(cars);
    }

    private static List<Car> mapToCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::from)
                .toList();
    }
}
