package racingcar.controller;

import racingcar.io.OutputView;

public class RacingCarController {

    private final OutputView outputView;

    public RacingCarController(final OutputView outputView) {
        this.outputView = outputView;
    }

    public void run() {
        outputView.printRacingCarNamesRequest();
    }
}
