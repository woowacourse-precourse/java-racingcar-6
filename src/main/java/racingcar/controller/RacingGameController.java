package racingcar.controller;

import racingcar.model.CarNames;

public class RacingGameController {

    private CarNames carNames;

    public RacingGameController() {
        this.carNames = new CarNames();
    }

    public void setCarName(String carName) {
        // validation & save car name
        carNames.saveCarNames(carName);
    }

    public void setAttempts(String attempts) {
        // validation
        // save attempts
    }

    public void startGame() {

    }
}
