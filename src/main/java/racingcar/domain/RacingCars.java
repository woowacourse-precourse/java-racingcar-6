package racingcar.domain;

import java.util.Collections;
import java.util.List;

public class RacingCars {

    private final List<RacingCar> racingCars;

    public RacingCars(final List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public Integer getMaxForwardDistance() {
        return Collections.max(racingCars).getForwardDistance();
    }

    public List<RacingCar> getRacingCars() {
        return Collections.unmodifiableList(racingCars);
    }
}
