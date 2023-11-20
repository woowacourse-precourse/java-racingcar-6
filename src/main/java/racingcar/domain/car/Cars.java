package racingcar.domain.car;

import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> carNames) {
        this.cars = initCars(carNames);
    }

    private List<Car> initCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .toList();
    }
}