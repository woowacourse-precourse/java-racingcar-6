package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private final static List<RacingCar> racingCars = new ArrayList<>();

    public void add(RacingCar racingCar) {
        racingCars.add(racingCar);
    }
}
