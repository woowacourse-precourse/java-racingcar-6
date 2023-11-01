package racingcar.controller;

import racingcar.domain.RacingGame;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;

public class RacingGameController {
    private final InputView inputView;
    private RacingGameService service;
    private RacingGame racingGame;

    public RacingGameController(InputView inputView) {
        this.inputView = inputView;
        service = RacingGameService.startGame();
    }

    public void run() {
        racingGame = inputView.getRacingGame();
        racingGame.setN(inputView.getMoveCount());
        while(racingGame.isNotZero()) {
            racingGame = service.moveCar(racingGame);
        }
    }
}
