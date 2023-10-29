package racingcar.controller;

import static racingcar.model.Settings.ATTEMPT_MAX;

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
        playRace();
        String winners = game.getWinners();

        View.displayWinners(winners);
    }

    private void playRace() {
        for (int round = 0; round < ATTEMPT_MAX; round++) {
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
        Settings.setAttempts(attempts);
    }

}
