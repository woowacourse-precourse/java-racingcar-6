package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void run() {
        outputView.beforeInputCarNames();
        String inputtedCarNames = inputView.inputCarNames();
    }
}
