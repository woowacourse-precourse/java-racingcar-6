package racingcar.controller;

import racingcar.view.InputView;

public class RacingcarController {
    private static final InputView inputView = InputView.getInstance();

    public void run() {
        start();
    }

    private void start() {
        inputView.getCarNames();
    }
}
