package racingcar.controller;

import racingcar.view.OutputView;

public class RaceController {

    private final OutputView outputView;

    public RaceController() {
        this.outputView = new OutputView();
    }

    public void run() {
        outputView.carNamesOutput();
    }
}
