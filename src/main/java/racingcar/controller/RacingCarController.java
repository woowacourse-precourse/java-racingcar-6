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

    public void outputResultMessage() {
        racingCarService.outputResultMessage();
    }

    public void outputMoveResult() {
        racingCarService.outputMoveResult();
    }

    public void outputWinner() {
        racingCarService.outputWinner();
    }
}
