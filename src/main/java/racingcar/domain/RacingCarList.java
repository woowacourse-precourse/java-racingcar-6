package racingcar.domain;

import java.util.Collections;
import java.util.List;

public class RacingCarList {

    private final List<RacingCar> racingCarList;

    public RacingCarList(List<RacingCar> racingCarList) {
        this.racingCarList = racingCarList;
    }

    public void add(RacingCar racingCar) {
        this.racingCarList.add(racingCar);
    }

    public List<RacingCar> getRacingCarList() {
        return Collections.unmodifiableList(racingCarList);
    }

}

