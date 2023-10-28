package racingcar.controller;

import racingcar.model.RacingGame;
import racingcar.model.Settings;
import racingcar.view.View;

public class Controller {
    RacingGame racingGame = new RacingGame();
    View view = new View();

    public void startGame() {
        askAndGenerateCars();
        askAndSetAttempts();
        racingGame.playGame();
    }

    private void askAndGenerateCars() {
        String[] cars = view.askForCarNames();
        racingGame.createAndAddCars(cars);
    }

    private void askAndSetAttempts() {
        int attempts = view.askForAttempts();
        Settings.setAttempts(attempts);
    }

}
