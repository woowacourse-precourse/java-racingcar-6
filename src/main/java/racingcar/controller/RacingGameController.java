package racingcar.controller;

import racingcar.view.InputView;

public class RacingGameController {
    InputView inputView = new InputView();

    public void gameStart() {
        inputView.getCarNames();
    }
}
