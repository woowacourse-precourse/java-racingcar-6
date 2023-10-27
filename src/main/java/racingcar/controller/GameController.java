package racingcar.controller;

import racingcar.view.input.InputView;
import racingcar.view.output.AskView;

public class GameController {

    private final AskView askView;
    private final InputView inputView;

    public GameController(final AskView askView, final InputView inputView) {
        this.askView = askView;
        this.inputView = inputView;
    }

    public void play() {
        askView.askCarNames();
    }
}
