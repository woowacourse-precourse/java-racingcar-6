package racingcar.domain;

import java.util.Arrays;
import java.util.List;

public class RacingCars {

    private static final String CAR_NAME_DELIMITER = ",";

    private final List<Car> cars;

    private RacingCars(List<Car> cars) {
        this.cars = cars;
    }

    public static RacingCars from(String carNames) {
        List<Car> cars = Arrays.stream(carNames.split(CAR_NAME_DELIMITER))
                .map(Car::new)
                .toList();
        return new RacingCars(cars);
    }

    public List<Car> getCars() {
        return cars;
    }
}
