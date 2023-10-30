package racingcar.controller;

import racingcar.view.OutputView;

public class RacingController {
    OutputView outputView = new OutputView();

    public void raceStart() {
        outputView.printInputCarNames();
    }
}
