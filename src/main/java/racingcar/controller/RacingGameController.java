package racingcar.controller;

import racingcar.domain.RacingGame;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;

public class RacingGameController {
    private final InputView inputView;
    private RacingGameService gameService;
    private RacingGame racingGame;

    public RacingGameController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        racingGame = inputView.getRacingGame();
        racingGame.setN(inputView.getMoveCount());
    }
}
