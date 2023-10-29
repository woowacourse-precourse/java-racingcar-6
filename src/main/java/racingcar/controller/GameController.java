package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.Round;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private static Round round;
    private static Cars racingCarGame;

    public static void run() {
        setGame();
        playGame();
        printWinner();
    }

    private static void setGame() {
        String[] carNames = InputView.inputCarNames();
        racingCarGame = Cars.from(carNames);

        round = InputView.inputRoundNumber();
    }

    private static void playGame() {
        OutputView.printPlayResultMessage();
        for (int i=0; i<round.getRound(); i++) {
            racingCarGame.playRound();
            OutputView.printPlayResult(racingCarGame.getCars());
        }
    }

    private static void printWinner() {
        OutputView.printWinnerMessage();
        OutputView.printWinner(racingCarGame.getWinners());
    }
}
