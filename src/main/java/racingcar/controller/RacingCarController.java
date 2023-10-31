package racingcar.controller;

import racingcar.constants.RacingCarMove;
import racingcar.io.input.InputManager;
import racingcar.io.output.OutputView;
import racingcar.model.Cars;
import racingcar.service.RacingCarService;

public class RacingCarController {

    private final InputManager inputManager;
    private final OutputView outputView;
    private final RacingCarService racingCarService;

    public RacingCarController(InputManager inputManager, OutputView outputView, RacingCarService racingCarService) {
        this.inputManager = inputManager;
        this.outputView = outputView;
        this.racingCarService = racingCarService;
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
        while (RacingCarMove.isProcessing(attemptCount)) {
            racingCarService.startRacing(cars);
            outputView.printGameResult(cars.statusCarsPosition());
            attemptCount = RacingCarMove.decreaseAttemptCount(attemptCount);
        }
        outputView.printFinalWinners(cars.getFinalWinners());
    }
}
