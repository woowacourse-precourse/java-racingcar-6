package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.util.InputParser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private static final InputView INPUT_VIEW = new InputView();
    private static final OutputView OUTPUT_VIEW = new OutputView();
    private static final InputParser INPUT_PARSER = new InputParser();
    private Cars cars;
    private int numberOfAttempt;

    public void run() {
        initGame();
        proceedGame();
        endGame();
    }

    private void initGame() {
        OUTPUT_VIEW.printCarNamePrompt();
        String carNamesInput = INPUT_VIEW.enterPlayerInput();
        OUTPUT_VIEW.printNumberOfAttemptPrompt();
        String attemptInput = INPUT_VIEW.enterPlayerInput();
        numberOfAttempt = INPUT_PARSER.parseNumberOfAttempt(attemptInput);
        cars = new Cars(INPUT_PARSER.parseCarName(carNamesInput));
    }

    private void proceedGame() {
        OUTPUT_VIEW.printResultMessage();
        for (int i = 0; i < numberOfAttempt; i++) {
            cars.driveAll();
            OUTPUT_VIEW.printResultRound(cars.getRoundResult());
        }
    }

    private void endGame() {
        OUTPUT_VIEW.printWinner(cars.getWinners());
    }
}
