package racingcar.controller;

import racingcar.domain.RacingCars;
import racingcar.io.InputManager;
import racingcar.io.OutputView;
import racingcar.service.RacingCarService;

public class RacingCarController {

    private final OutputView outputView;
    private final InputManager inputManager;
    private final RacingCarService racingCarService;

    public RacingCarController(
            final OutputView outputView,
            final InputManager inputManager,
            final RacingCarService racingCarService) {
        this.outputView = outputView;
        this.inputManager = inputManager;
        this.racingCarService = racingCarService;
    }

    public void run() {
        createRacingCars();
    }

    private void createRacingCars() {
        outputView.printRacingCarNamesRequest();
        final RacingCars racingCars = inputManager.readRacingCarNames();
        racingCarService.saveRacingCars(racingCars);
    }
}
