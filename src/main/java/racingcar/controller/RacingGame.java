package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    public void play() {
        outputView.racingStart();
        String carNames = inputView.input();
    }
}
