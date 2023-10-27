package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingcarGameController {
    InputView inputView;
    OutputView outputView;

    public RacingcarGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start() {
        inputView.carsName();
    }
}
