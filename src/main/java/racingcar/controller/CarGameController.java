package racingcar.controller;

import racingcar.domain.CarGameManager;
import racingcar.domain.Cars;

public class CarGameController {

    private Cars cars;

    private CarGameManager carGameManager = new CarGameManager();

    public void set() {
        this.cars = carGameManager.carNamesSet();
    }
}
