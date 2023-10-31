package racingcar.controller;

import java.util.stream.IntStream;
import racingcar.game.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    public void start() {
        String[] carNames = InputView.startGameCommand();
        int tryCount = InputView.getTryCount();
        RacingGame racingGame = new RacingGame(carNames);
        OutputView.printResultCommand();
        for (int i = 0; i < tryCount; ++i) {
            racingGame.proceedRound();
            OutputView.printRoundResult(racingGame.getCarList());
        }
        OutputView.printWinners(racingGame.getWinners());
    }
}
