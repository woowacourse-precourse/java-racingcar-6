package racingcar.domain;

import java.util.List;

public class RacingCars {
    private final List<Car> cars;

    public RacingCars(final List<String> userInputCars) {
        this.cars = convertStringToCar(userInputCars);
    }

    private List<Car> convertStringToCar(final List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .toList();
    }

    public List<Car> getCars() {
        return cars;
    }
}
