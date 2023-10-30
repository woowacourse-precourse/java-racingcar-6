package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private final List<Car> cars;

    public RacingCars(List<String> carNames) {
        cars = new ArrayList<>();
        carNames.forEach(carName -> cars.add(new Car(carName)));
    }

    public void moveOrStop() {
        cars.forEach(Car::move);
    }

    public List<Car> getCars() {
        return cars;
    }
}
