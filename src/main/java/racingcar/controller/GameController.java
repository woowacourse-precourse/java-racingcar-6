package racingcar.controller;

import racingcar.view.InputView;
import racingcar.model.RacingCarGame;
import racingcar.view.OutputView;

public class GameController {

    private static int round;

    public static void run() {
        String[] carNames = InputView.inputCarNames();
        RacingCarGame racingCarGame = RacingCarGame.from(carNames);

        round = InputView.inputRoundNumber();
        OutputView.printPlayResultMessage();
        for (int i=0; i<round; i++) {
            racingCarGame.playRound();
            OutputView.printPlayResult(racingCarGame.getCars());
        }
    }
}
