package racingcar.controller;

import racingcar.service.RacingCarService;

public class RacingCarController {

    private final RacingCarService racingCarService = new RacingCarService();

    public void createCars() {
        racingCarService.createCars();
    }

    public int inputAttemptNumber() {
        return racingCarService.inputAttemptNumber();
    }

    public void moveCars() {
        racingCarService.moveCars();
    }
}
