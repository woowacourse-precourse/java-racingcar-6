package racingcarv2;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private final List<Car> racingCars;

    public RacingCars(List<Car> racingCars) {
        this.racingCars = new ArrayList<>(racingCars);
    }

    public List<Car> getRacingCars() {
        return new ArrayList<>(racingCars);
    }
}
