package racingcar.domain;

import java.util.List;

public class CarFactory {
    private CarFactory() {
    }

    public static Cars createRacingCars(List<String> carNames) {
        List<Car> cars = carNames.stream()
                .map(Car::new)
                .toList();

        return new Cars(cars);
    }
}
