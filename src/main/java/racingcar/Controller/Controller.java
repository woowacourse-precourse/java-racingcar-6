package racingcar.Controller;

import racingcar.Model.RacingGame;
import racingcar.Model.Settings;

public class Controller {
    RacingGame racingGame = new RacingGame();

    public void requestStartGame() {
        RacingGame.startGame();
    }

    public void requestCarGenerate(String[] cars) {
        racingGame.createAndAddCars(cars);
        requestSetCarAmount(cars);
    }

    public void requestSetAttempts(int attempts) {
        Settings.setAttempts(attempts);
    }

    private void requestSetCarAmount(String[] cars) {
        Settings.setCarAmount(cars.length);
    }

}
