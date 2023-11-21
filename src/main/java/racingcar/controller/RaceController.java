package racingcar.controller;

import racingcar.domain.racinggame.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public final class RaceController {


    private final InputView inputView;
    private final OutputView outputView;

    public RaceController(
            final InputView inputView,
            final OutputView outputView
    ) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        final RacingGame racingGame = inputView.inputRacingGame();
        racingGame.play();
        outputView.printRoundsResult(racingGame.getRoundsResult());
        outputView.printWinners(racingGame.getWinners());
    }
}
