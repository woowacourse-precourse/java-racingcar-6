package racingcar.controller;

import racingcar.model.CarList;

public class RacingGameController {
    private CarList carList;
    private int roundNum;

    public void run() {
        init();
    }

    public void init() {
        carList = InputController.initCarList();
        roundNum = InputController.initRoundNum();
    }
}
