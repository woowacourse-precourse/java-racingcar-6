package racingcar.controller;

import racingcar.model.RacingGame;
import racingcar.view.OutputView;

public class RacingGameController {
    private final RacingGame racingGame;

    public RacingGameController(RacingGame racingGame) {
        this.racingGame = racingGame;
    }

    public void play() {
        OutputView.printExecutionResultText();

        for (int round = 1; round <= racingGame.round(); round++) {
            racingGame.proceedRound();
            OutputView.printRoundResult(racingGame.cars());
            OutputView.printNewLine();
        }

        OutputView.printWinners(racingGame.cars());
    }
}
