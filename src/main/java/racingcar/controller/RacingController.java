package racingcar.controller;

import racingcar.domain.GameTry;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        String carNames = InputView.inputCarNames();
        GameTry gameTry = new GameTry(InputView.inputTryNumber());
        RacingGame racingGame = new RacingGame(carNames, gameTry);
        OutputView.printMainMessage();
    }
}
