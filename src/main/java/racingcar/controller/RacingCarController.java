package racingcar.controller;

import racingcar.io.input.InputManager;
import racingcar.io.output.OutputView;
import racingcar.model.Cars;
import racingcar.service.RacingCarService;

public class RacingCarController {

    private final InputManager inputManager;
    private final OutputView outputView;
    private final RacingCarService racingCarService;

    public RacingCarController() {
        this.inputManager = new InputManager();
        this.outputView = new OutputView();
        this.racingCarService = new RacingCarService();
    }

    public void run() {
        outputView.printRacingCarNamesMessage();
        Cars cars = inputManager.inputCarNames();

        outputView.printAttemptCountMessage();
        int attemptCount = inputManager.inputAttemptCount();

        startRacing(cars, attemptCount);
    }

    private void startRacing(Cars cars, int attemptCount) {
        outputView.printExecutionResultMessage();
        while (racingCarService.isProcessing(attemptCount)) {
            racingCarService.startRacing(cars);
            outputView.printGameResult(cars.statusCarsPosition());
        }
        outputView.printFinalWinners(cars.getFinalWinners());
    }
}
