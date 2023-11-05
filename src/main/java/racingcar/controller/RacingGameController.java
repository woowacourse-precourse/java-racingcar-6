package racingcar.controller;

import racingcar.model.RacingGameModel;
import racingcar.view.RacingGameView;

public class RacingGameController {

    private final RacingGameModel model;
    private final RacingGameView view;

    public RacingGameController() {
        model = new RacingGameModel();
        view = new RacingGameView();
    }

    public void startRacingGame() {
        inputCarNamesAndAttempts();
        playRacingGame();
        printWinners();
    }

    private void inputCarNamesAndAttempts() {
        String carNames = view.readCarNamesFromConsole();
        int attempts = view.convertAttemptsToIntFromConsoleStringInput();
        model.setCarNames(carNames);
        model.setAttempts(attempts);
    }

    private void playRacingGame() {
        view.printResultMessage();
        for (int i = 0; i < model.getAttempts(); i++) {
            model.moveCars();
            view.printRoundResults(model.getCars());
        }
    }

    private void printWinners() {
        view.printWinners(model.getWinners());
    }
}