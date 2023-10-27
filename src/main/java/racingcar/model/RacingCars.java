package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private final List<RacingCar> racingCars;

    public RacingCars(RacingCarsListMaker racingCarsListMaker) {
        this.racingCars = racingCarsListMaker.getRacingCarsList();
    }
}
