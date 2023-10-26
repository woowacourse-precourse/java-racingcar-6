package racingcar.controller;

import racingcar.view.OutputView;
import racingcar.view.InputView;

public class RacingController {

    public void start() {
        String[] carNames = InputView.inputCarName();
        OutputView.printInputRacingCount();
    }
}
