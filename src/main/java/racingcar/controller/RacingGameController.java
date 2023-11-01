package racingcar.controller;

import racingcar.model.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    private RacingGame racingGame = new RacingGame();

    public void proceed() {
        initRacingGame();
        playGame();
    }

    private void initRacingGame() {
        racingGame.setCarNames(InputView.inputCarNames());
        racingGame.setTryCount(InputView.inputTryCount());
    }

    private void playGame() {
        OutputView.printResult(racingGame.race());
        OutputView.printFinalWinners(racingGame.getWinners());
    }
}
