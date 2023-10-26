package racingcar.controller;

import racingcar.view.InputView;

public class RacingGame {

    public static final InputView inputView = new InputView();

    private RacingGame() {
    }

    public static void run() {
        String carNames = inputView.enterCarNames();
    }
}
