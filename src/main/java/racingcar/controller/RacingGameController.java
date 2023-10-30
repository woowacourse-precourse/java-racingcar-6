package racingcar.controller;

import racingcar.domain.RacingCars;

public class RacingGameController {

    private final RacingInputController racingInputController = new RacingInputController();
    private RacingCars racingCars;
    private int tryCount;

    public void start() {
        set();
    }

    private void set() {
        racingCars = racingInputController.createRacingCars();
        tryCount = racingInputController.createTryCount();
    }

}
