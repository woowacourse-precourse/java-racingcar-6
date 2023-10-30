package racingcar.domain.racing;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;

public class CarManager {
    private final List<Car> cars;

    public CarManager(String carNames) {
        this.cars = Arrays.stream(carNames.split(","))
                .map(String::trim)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }
}