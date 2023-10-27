package racingcar.repository;

import racingcar.domain.RacingCars;

public class RacingCarsRepository {

    private RacingCars racingCars;

    public void save(final RacingCars racingCars) {
        this.racingCars = racingCars;
    }
}
