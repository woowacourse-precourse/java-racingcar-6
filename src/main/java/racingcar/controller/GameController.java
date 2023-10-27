package racingcar.controller;

import racingcar.view.InputView;

public class GameController {
    private final InputView inputView = new InputView();
    public void start() {
        inputView.name();
    }
}
