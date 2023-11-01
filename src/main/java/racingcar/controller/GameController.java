package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.RacingGame;
import racingcar.view.ConsoleView;

import java.util.List;

public class GameController {
    private final RacingGame racingGame;
    private final ConsoleView consoleView;

    public GameController(RacingGame racingGame, ConsoleView consoleView) {
        this.racingGame = racingGame;
        this.consoleView = consoleView;
    }

    public void playGame(int numberOfAttempts) {
        moveCarsAndPrintPositions(numberOfAttempts);
        List<Car> winners = racingGame.getWinners();
        consoleView.printWinners(winners);
    }

    private void moveCarsAndPrintPositions(int numberOfAttempts) {
        for (int i = 0; i < numberOfAttempts; i++) {
            racingGame.moveCars();
            consoleView.printCurrentPositions(racingGame.getCars());
        }
    }

}
