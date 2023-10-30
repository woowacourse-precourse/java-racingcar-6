package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();

    public void raceStart() {
        outputView.printInputCarNames();
        String carNames = inputView.carNames();
    }
}
