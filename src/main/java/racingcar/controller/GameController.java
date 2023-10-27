package racingcar.controller;

import racingcar.view.output.AskView;

public class GameController {

    private final AskView askView;

    public GameController(final AskView askView) {
        this.askView = askView;
    }

    public void play() {
        askView.askCarNames();
    }
}
