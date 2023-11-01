package racingcar.controller;

import racingcar.model.RacingCars;

public class GameController {
    private RacingCars racingCars;
    private int roundNum;

    public GameController() {
        set();
        play();
        showWinner();
    }

    public void set() {
        racingCars = InputController.setRacingCars();
        roundNum = InputController.setRoundNum();
    }
}
