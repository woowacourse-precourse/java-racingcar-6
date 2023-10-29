package racingcar.controller;

import racingcar.model.RacingGame;
import racingcar.view.InputView;

import java.util.List;

public class RacingController {
    private final InputView inputView;

    public RacingController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        RacingGame racingGame = setRacingGame();
    }

    private RacingGame setRacingGame() {
        List<String> names = inputView.inputCarNames();
        Integer tryCount = inputView.inputTryCount();
        return new RacingGame(names, tryCount);
    }
}
