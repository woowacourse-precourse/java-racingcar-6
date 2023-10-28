package racingcar.service;

import racingcar.domain.RacingCarStatus;
import racingcar.domain.RacingCars;
import racingcar.domain.RacingCarStatusGroup;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGameService {

    private RacingCarStatusGroup racingCarStatusGroup;
    private List<RacingCarStatus> racingCarStatusList = new ArrayList<>();

    public void generateRacingCarGroup(RacingCars racingCars) {
        for (String carName : racingCars.getCarNames()) {
            RacingCarStatus racingCarStatus = new RacingCarStatus(carName);
            racingCarStatusList.add(racingCarStatus);
        }

        racingCarStatusGroup = new RacingCarStatusGroup(racingCarStatusList);
    }

    public void racingCarGameProgress(RacingCars racingCar) {

    }
}
