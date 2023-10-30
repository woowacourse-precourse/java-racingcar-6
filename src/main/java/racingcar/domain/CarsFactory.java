package racingcar.domain;

import java.util.List;

public class CarsFactory {
    private CarsFactory() {
    }

    public static Cars createRacingCars(List<String> carNames) {
        List<Car> cars = carNames.stream()
                .map(Car::new)
                .toList();

        return new Cars(cars);
    }
}
