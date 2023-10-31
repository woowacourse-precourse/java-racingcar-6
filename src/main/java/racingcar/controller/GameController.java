package racingcar.controller;

import racingcar.game.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    public void start() {
        String[] carNames = InputView.startGameCommand();
        int tryCount = InputView.getTryCount();
        RacingGame racingGame = new RacingGame(carNames, tryCount);
        OutputView.printResultCommand();
        racingGame.run();
        racingGame.printWinners();
    }
}
