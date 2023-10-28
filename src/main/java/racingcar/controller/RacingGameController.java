package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.CarList;
import racingcar.view.InputView;

public class RacingGameController {
    private CarList carList;

    public void run() {
        init();
    }

    public void init() {
        carList = InputController.initCarList();
    }
}
