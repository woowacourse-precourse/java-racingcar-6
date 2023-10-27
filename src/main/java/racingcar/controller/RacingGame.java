package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {
    public void play() {
        OutputView.displayCarNames();
        String names = InputView.input();

        OutputView.displayAttemptCount();
        int attemptCount = Integer.parseInt(InputView.input());
    }
}
