package racingcarv2.model;

import java.util.ArrayList;
import java.util.List;
import racingcarv2.model.Car;

public class RacingCars {
    private final List<Car> racingCars;

    public RacingCars(List<Car> racingCars) {
        this.racingCars = new ArrayList<>(racingCars);
    }

    public List<Car> getRacingCars() {
        return new ArrayList<>(racingCars);
    }
}
