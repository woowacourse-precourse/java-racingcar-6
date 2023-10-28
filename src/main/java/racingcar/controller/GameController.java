package racingcar.controller;

import racingcar.view.OutputView;

public class GameController {
    private final OutputView outputView = new OutputView();

    public void start() {
        outputView.printInputCarNameMessage();
    }
}
