package racingcar.controller;

import racingcar.view.InputView;

public class RacingCarController {
    public void startGame() {
        getCarName();
    }

    public String getCarName() {
        return InputView.setCarNames();
    }
}
