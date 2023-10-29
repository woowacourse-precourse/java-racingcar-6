package racingcar.controller;

import racingcar.model.CarManager;
import racingcar.model.RacingGame;
import racingcar.model.Settings;
import racingcar.view.View;

public class Controller {
    CarManager manager = new CarManager();
    RacingGame game = new RacingGame(manager);

    public void startGame() {
        askAndGenerateCars();
        askAndSetAttempts();

        View.displayResult();
        game.playGame();

        String winners = game.getWinners();
        View.displayWinners(winners);
    }

    private void askAndGenerateCars() {
        String[] cars = View.askForCarNames();
        manager.createAndAddCars(cars);
    }

    private void askAndSetAttempts() {
        int attempts = View.askForAttempts();
        Settings.setAttempts(attempts);
    }

}
