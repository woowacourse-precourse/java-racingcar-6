package racingcar.controller;

import racingcar.InputValidator;
import racingcar.model.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingGameController {
    private RacingGame racingGame;
    int tryCount;

    public void proceed() {
        initRacingGame();
        initTryCount();
        playGame();
        showFinalWinners();
    }

    private void initRacingGame() {
        List<String> carNames = InputView.inputCarNames();
        InputValidator.validate(carNames);
        racingGame = new RacingGame(carNames);
    }

    private void initTryCount() {
        int tryCount = InputView.inputTryCount();
        InputValidator.validate(tryCount);
        this.tryCount = tryCount;
    }

    private void playGame() {
        OutputView.printResultMessage();
        for (int i = 0; i < tryCount; ++i) {
            OutputView.printMove(racingGame.race());
        }
    }

    private void showFinalWinners() {
        OutputView.printFinalWinners(racingGame.getWinners());
    }
}
