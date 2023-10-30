package racingcar.service;

import racingcar.model.CarList;
import racingcar.model.TryNumber;

public class RaceService {
    private CarList carList;
    private TryNumber tryNumber;

    public void makeCarList(String carNames) {
        carList = new CarList(carNames);
    }

    public void makeTryCount(String tryCount) {
        tryNumber = new TryNumber(tryCount);
    }
}
