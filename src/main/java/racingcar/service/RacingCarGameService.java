package racingcar.service;

import racingcar.domain.RacingCarStatus;
import racingcar.domain.RacingCars;
import racingcar.domain.RacingCarStatusGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    public void racingCarGameProgress() {
        racingCarStatusGroup.moveForward();
    }

    public List<Map<String, String>> racingCarGameResult() {
        List<Map<String, String>> racingCarsInfo = new ArrayList<>();
        List<RacingCarStatus> finishCarList = racingCarStatusGroup.getFinishCarList();

        for (RacingCarStatus finishCar : finishCarList) {
            Map<String, String> carInfos = finishCar.getCarStatus();
            racingCarsInfo.add(carInfos);
        }

        return racingCarsInfo;
    }

    public String getWinnerNames() {
        RacingCarStatus maxPositionCar = racingCarStatusGroup.getMaxPosition();
        List<String> winners = racingCarStatusGroup.getWinnerNames(maxPositionCar);

        String winnerNames = String.join(", ", winners);

        return winnerNames;
    }
}
