package racingcar.service;

import racingcar.domain.RacingCars;
import racingcar.domain.RacingCarStatusGroup;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGameService {

    private RacingCarStatusGroup racingCarGroup;
    private List<RacingCars> racingCarList = new ArrayList<>();

    public void generateRacingCarGroup(RacingCars racingCar) {
        racingCarList.add(racingCar);
        racingCarGroup = new RacingCarStatusGroup(racingCarList);
    }

    public void racingCarGameProgress(RacingCars racingCar) {

    }
}
