package racingcar.controller;

import racingcar.view.InputView;
import racingcar.model.RacingCarGame;
import racingcar.view.OutputView;

public class GameController {

    private static int round;
    private static RacingCarGame racingCarGame;

    public static void run() {
        setGame();
        playGame();
        printWinner();
    }

    private static void setGame() {
        String[] carNames = InputView.inputCarNames();
        racingCarGame = RacingCarGame.from(carNames);

        round = InputView.inputRoundNumber();
    }

    private static void playGame() {
        OutputView.printPlayResultMessage();
        for (int i=0; i<round; i++) {
            racingCarGame.playRound();
            OutputView.printPlayResult(racingCarGame.getCars());
        }
    }

    private static void printWinner() {
        OutputView.printWinnerMessage();
        OutputView.printWinner(racingCarGame.getWinners());
    }
}
