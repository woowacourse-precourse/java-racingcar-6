package racingcar.service;

import racingcar.domain.CarStatus;
import racingcar.domain.CarStatusGroup;
import racingcar.domain.wrapper.CarNames;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static racingcar.handler.ConstantsHandler.JOIN_MARK;

public class CarGameService {

    private CarStatusGroup carStatusGroup;
    private List<CarStatus> carStatusList = new ArrayList<>();

    public void generateStatusGroup(CarNames carNames) {
        for (String carName : carNames.getCarNames()) {
            CarStatus carStatus = CarStatus.create(carName);
            carStatusList.add(carStatus);
        }

        carStatusGroup = CarStatusGroup.create(carStatusList);
    }

    public void carGameProgress() {
        carStatusGroup.moveForward();
    }

    public List<Map<String, String>> carGameResult() {
        List<Map<String, String>> racingCarsInfo = new ArrayList<>();
        List<CarStatus> gameResults = carStatusGroup.getCarStatusList();

        for (CarStatus gameResult : gameResults) {
            Map<String, String> carInfo = gameResult.getCarStatus();
            racingCarsInfo.add(carInfo);
        }

        return racingCarsInfo;
    }

    public String getWinnerNames() {
        CarStatus maxPositionCar = carStatusGroup.getMaxPosition();
        List<String> winnerNames = carStatusGroup.getWinnerNames(maxPositionCar);

        String winners = String.join(JOIN_MARK, winnerNames);

        return winners;
    }
}
