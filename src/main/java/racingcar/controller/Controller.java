package racingcar.controller;

import racingcar.model.RacingGame;
import racingcar.model.Settings;
import racingcar.view.InputView;

public class Controller {
    RacingGame racingGame = new RacingGame();
    InputView inputView = new InputView();

    public void startGame() {
        askAndGenerateCars();
        askAndSetAttempts();
        racingGame.playGame();
    }

    private void askAndGenerateCars() {
        String[] cars = inputView.askForCarNames();
        racingGame.createAndAddCars(cars);
    }

    private void askAndSetAttempts() {
        int attempts = inputView.askForAttempts();
        Settings.setAttempts(attempts);
    }

}
