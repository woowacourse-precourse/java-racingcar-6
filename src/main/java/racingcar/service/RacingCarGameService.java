package racingcar.service;

import racingcar.domain.RacingCar;
import racingcar.domain.RacingCarGroup;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGameService {

    private RacingCarGroup racingCarGroup;
    private List<RacingCar> racingCarList = new ArrayList<>();

    public void generateRacingCarGroup(RacingCar racingCar) {
        racingCarList.add(racingCar);
        racingCarGroup = new RacingCarGroup(racingCarList);
    }

    public void racingCarGameProgress(RacingCar racingCar) {

    }
}
