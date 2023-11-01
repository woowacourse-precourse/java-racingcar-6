package racingcar.controller;

import racingcar.domain.RacingGame;
import racingcar.domain.RacingGameResult;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private RacingGameService service;
    private RacingGame racingGame;

    public RacingGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        service = RacingGameService.startGame();
    }

    public void run() {
        racingGame = inputView.getRacingGame();
        racingGame.setN(inputView.getMoveCount());
        while (racingGame.isNotZero()) {
            racingGame = service.moveCar(racingGame);
            outputView.printCurrentResult(racingGame);
        }
        RacingGameResult gameResult = service.findWinner(racingGame);
        outputView.printWinner(gameResult);
    }
}
