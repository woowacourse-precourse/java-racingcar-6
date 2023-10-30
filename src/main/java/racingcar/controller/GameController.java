package racingcar.controller;

import racingcar.view.InputView;

public record GameController(InputView inputView) {

    public void run() {
        String carNames = inputView.inputCarNames();
    }
}
