package racingcar.controller;

import racingcar.model.CarManager;
import racingcar.model.RacingGame;
import racingcar.model.Settings;
import racingcar.view.View;

public class Controller {
    CarManager manager = new CarManager();
    RacingGame game = new RacingGame(manager);
    View view = new View();

    public void startGame() {
        askAndGenerateCars();
        askAndSetAttempts();

        view.displayResult();
        game.playGame();

        String winners = game.getWinners();
        view.displayWinners(winners);
    }

    private void askAndGenerateCars() {
        String[] cars = view.askForCarNames();
        manager.createAndAddCars(cars);
    }

    private void askAndSetAttempts() {
        int attempts = view.askForAttempts();
        Settings.setAttempts(attempts);
    }

}
