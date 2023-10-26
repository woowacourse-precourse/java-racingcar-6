package racingcar.Controller;

import racingcar.Model.RacingGame;
import racingcar.Model.Settings;

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
