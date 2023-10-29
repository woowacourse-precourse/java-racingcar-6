package racingcar.controller;

import static racingcar.config.Settings.ROUND_MAX;

import racingcar.config.Settings;
import racingcar.model.CarManager;
import racingcar.model.RacingGame;
import racingcar.view.View;

public class Controller {
    CarManager manager = new CarManager();
    RacingGame game = new RacingGame(manager);

    public void startGame() {
        askAndGenerateCars();
        askAndSetAttempts();

        View.displayResult();
        playRace();
        String winners = game.getWinners();

        View.displayWinners(winners);
    }

    private void playRace() {
        for (int round = 0; round < ROUND_MAX; round++) {
            String roundResult = game.playRound();
            View.displayRoundResult(roundResult);
        }
    }

    private void askAndGenerateCars() {
        String[] cars = View.askForCarNames();
        manager.createAndAddCars(cars);
    }

    private void askAndSetAttempts() {
        int attempts = View.askForAttempts();
        Settings.setRound(attempts);
    }

}
