package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.CarList;
import racingcar.view.InputView;

public class RacingGameController {
    private CarList carList;
    private int tryCount;

    public void run() {
        init();
    }

    public void init() {
        carList = InputController.initCarList();

    }
}
