package racingcar.controller;

import racingcar.view.OutputView;

public class Game {

    private final OutputView outputView;

    public Game(OutputView outputView) {
        this.outputView = outputView;
    }

    public void start() {
        outputView.printGameStart();
    }
}
