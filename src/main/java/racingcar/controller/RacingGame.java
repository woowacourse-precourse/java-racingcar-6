package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {
    public void play() {
        OutputView.displayCarNames();
        String names = InputView.askRacingCarNames();
    }
}
