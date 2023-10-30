package racingcar.controller;

import racingcar.model.RacingGameModel;
import racingcar.view.RacingGameView;

public class RacingGameController {

    private final RacingGameModel model;
    private final RacingGameView view;
    private static final String RESULT_MESSAGE = "실행 결과";

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
        model.initializeCars(carNames);
        model.setNumberOfAttempts(attempts);
    }

    private void playRacingGame() {
        System.out.println();
        System.out.println(RESULT_MESSAGE);
        for (int i = 0; i < model.getAttempts(); i++) {
            model.moveCars();
            view.printRoundResults(model.getCars());
        }
    }

    private void printWinners() {
        view.printWinners(model.getWinners());
    }
}