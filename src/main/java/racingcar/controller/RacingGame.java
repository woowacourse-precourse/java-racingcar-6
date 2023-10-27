package racingcar.controller;

import racingcar.view.OutputView;

public class RacingGame {
    OutputView outputView = new OutputView();
    public void play() {
        outputView.printStart();
    }
}
