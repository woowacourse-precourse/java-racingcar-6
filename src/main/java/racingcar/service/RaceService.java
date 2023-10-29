package racingcar.service;

import racingcar.model.CarList;

public class RaceService {
    CarList carList;

    public void makeCarList(String carNames) {
        this.carList = new CarList(carNames);
    }
}
