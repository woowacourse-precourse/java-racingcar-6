package racingcar.controller;

import racingcar.view.console.InputView;
import racingcar.view.console.OutputView;

public class RaceController {
    private final InputView inputView;
    private final OutputView outputView;

    public RaceController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }
}
