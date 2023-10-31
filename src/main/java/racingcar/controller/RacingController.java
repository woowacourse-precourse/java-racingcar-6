package racingcar.controller;

import racingcar.domain.CarList;
import racingcar.view.InputView;

public class RacingController {
    private InputView inputView;

    public RacingController() {
        this.inputView = new InputView();
    }

    public void run() {
        CarList carList = inputView.inputPlayer();
    }
}
