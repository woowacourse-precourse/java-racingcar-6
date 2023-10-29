package racingcar.controller;

import racingcar.view.InputView;

public class RacingCarController {
    private final InputView inputView;

    public RacingCarController() {
        inputView = new InputView();
    }

    public void startRacing() {
        String carNames = inputView.inputCarNames();
    }
}
