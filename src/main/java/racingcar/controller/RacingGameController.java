package racingcar.controller;

import racingcar.view.InputView;

public class RacingGameController {

    public void startGame() {
        InputView inputView = new InputView();
        inputView.inputCarNames();
    }
}
