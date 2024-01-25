package racingcar.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import racingcar.constants.RacingCarMove;
import racingcar.io.input.InputManager;
import racingcar.io.output.OutputView;
import racingcar.model.Cars;
import racingcar.service.CarService;

@Component
@RequiredArgsConstructor
public class RacingCarController {

    private final InputManager inputManager;
    private final OutputView outputView;
    private final CarService racingCarService;

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
