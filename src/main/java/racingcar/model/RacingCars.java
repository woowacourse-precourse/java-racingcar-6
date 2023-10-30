package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private final List<Car> racingCars;

    public RacingCars() {
        this.racingCars = new ArrayList<>();
    }

    public void addCar(Car car) {
        racingCars.add(car);
    }
}
