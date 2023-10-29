package racingcar.service;

import racingcar.domain.CarStatus;
import racingcar.domain.Cars;
import racingcar.domain.CarStatusGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CarGameService {

    private CarStatusGroup carStatusGroup;
    private List<CarStatus> carStatusList = new ArrayList<>();

    public void generateRacingCarGroup(Cars cars) {
        for (String carName : cars.getCarNames()) {
            CarStatus carStatus = new CarStatus(carName);
            carStatusList.add(carStatus);
        }

        carStatusGroup = new CarStatusGroup(carStatusList);
    }

    public void racingCarGameProgress() {
        carStatusGroup.moveForward();
    }

    public List<Map<String, String>> racingCarGameResult() {
        List<Map<String, String>> racingCarsInfo = new ArrayList<>();
        List<CarStatus> finishCarList = carStatusGroup.getFinishCarList();

        for (CarStatus finishCar : finishCarList) {
            Map<String, String> carInfos = finishCar.getCarStatus();
            racingCarsInfo.add(carInfos);
        }

        return racingCarsInfo;
    }

    public String getWinnerNames() {
        CarStatus maxPositionCar = carStatusGroup.getMaxPosition();
        List<String> winners = carStatusGroup.getWinnerNames(maxPositionCar);

        String winnerNames = String.join(", ", winners);

        return winnerNames;
    }
}
