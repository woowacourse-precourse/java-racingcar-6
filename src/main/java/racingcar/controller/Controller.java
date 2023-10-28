package racingcar.controller;

import racingcar.model.RacingGame;
import racingcar.model.Settings;
import racingcar.view.View;

public class Controller {
    RacingGame game = new RacingGame();
    View view = new View();

    public void startGame() {
        askAndGenerateCars();
        askAndSetAttempts();
        game.playGame();
    }

    private void askAndGenerateCars() {
        String[] cars = view.askForCarNames();
        game.createAndAddCars(cars);
    }

    private void askAndSetAttempts() {
        int attempts = view.askForAttempts();
        Settings.setAttempts(attempts);
    }

}
