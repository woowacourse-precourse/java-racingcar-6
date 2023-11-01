package racingcar;

import java.util.List;

public class RacingCars {

    private final List<Car> cars;

    public RacingCars(List<String> names) {
        this.cars = names.stream()
                .map(Car::new)
                .toList();
    }

    public List<Car> getCars() {
        return cars;
    }
}
