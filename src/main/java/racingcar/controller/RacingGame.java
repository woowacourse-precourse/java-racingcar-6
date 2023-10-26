package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {
    private final OutputView outputView;
    private final InputView iutputView;
    

    public RacingGame() {
        this.outputView = new OutputView();
        this.iutputView = new InputView();
    }

    public void run() {
    }
}
