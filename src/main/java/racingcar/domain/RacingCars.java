package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    List<RacingCar> racingcars;

    public RacingCars() {
        racingcars = new ArrayList<>();
    }


    public void add(RacingCar racingcar) {
        racingcars.add(racingcar);
    }


}