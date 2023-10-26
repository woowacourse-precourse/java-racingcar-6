package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    public void start() {
        OutputView.printCarNameInputMessage();
        InputView.inputCarNames();
    }
}
