package racingcar.domain;

import java.util.Collections;
import java.util.List;

public class RacingCars {

    private final List<RacingCar> racingCars;

    public RacingCars(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public void add(RacingCar racingCar) {
        this.racingCars.add(racingCar);
    }

    public List<RacingCar> getRacingCars() {
        return Collections.unmodifiableList(racingCars);
    }

}

