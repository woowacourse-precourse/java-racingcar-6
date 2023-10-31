package racingcar.domain;

import java.util.List;

public class RacingCarManager {

    private final CarList carList;

    public RacingCarManager(List<String> carNames) {
        carList = new CarList(carNames);
    }

    public void playRacingGame() {
        for (Car car : carList.getCarList()) {
            car.moveOrStop();
        }
    }

}
