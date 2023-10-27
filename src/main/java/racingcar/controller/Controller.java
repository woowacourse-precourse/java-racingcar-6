package racingcar.controller;

import racingcar.model.RacingGame;
import racingcar.model.Settings;

public class Controller {
    RacingGame racingGame = new RacingGame();

    public void requestStartGame() {
        racingGame.startGame();
    }

    public void requestCarGenerate(String[] cars) {
        racingGame.createAndAddCars(cars);
    }

    public void requestSetAttempts(int attempts) {
        Settings.setAttempts(attempts);
    }

    public void requestSetCarAmount(String[] cars) {
        Settings.setCarAmount(cars.length);
    }

}
