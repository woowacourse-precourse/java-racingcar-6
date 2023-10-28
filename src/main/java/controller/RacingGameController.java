package controller;

import view.InputView;
import view.OutputView;

public class RacingGameController {

    private final OutputView outputView;
    private final InputView inputView;

    public RacingGameController(final OutputView outputView, final InputView inputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }
}
