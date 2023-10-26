package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Garage {

    private List<Car> cars;

    private Garage(List<Car> cars) {
        this.cars = cars;
    }

    public static Garage fromCarNames(List<String> carNames) {
        List<Car> cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        return new Garage(cars);
    }
}
