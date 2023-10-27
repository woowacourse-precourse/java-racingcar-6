package racingcar.controller;

import racingcar.domain.RacingCars;
import racingcar.io.InputManager;
import racingcar.io.OutputView;

public class RacingCarController {

    private final OutputView outputView;
    private final InputManager inputManager;

    public RacingCarController(final OutputView outputView, final InputManager inputManager) {
        this.outputView = outputView;
        this.inputManager = inputManager;
    }

    public void run() {
        outputView.printRacingCarNamesRequest();
        final RacingCars racingCars = inputManager.readRacingCarNames();
    }
}
