package racingcar.controller;

import racingcar.domain.RacingCars;
import racingcar.domain.TryCount;
import racingcar.domain.Winners;
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
        createTryCount();
        move();
        checkWinners();
    }

    private void checkWinners() {
        final Winners winners = racingCarService.checkWinners();
        outputView.printWinners(winners);
    }

    private void move() {
        outputView.printResult();
        TryCount tryCount = racingCarService.findTryCount();

        while (tryCount.hasLeftCount()) {
            final RacingCars racingCars = racingCarService.move();
            outputView.printRacingCars(racingCars);
            tryCount = tryCount.next();
        }
    }

    private void createTryCount() {
        outputView.printTryCountRequest();
        final TryCount tryCount = inputManager.readTryCount();
        racingCarService.saveTryCount(tryCount);
    }

    private void createRacingCars() {
        outputView.printRacingCarNamesRequest();
        final RacingCars racingCars = inputManager.readRacingCarNames();
        racingCarService.saveRacingCars(racingCars);
    }
}
