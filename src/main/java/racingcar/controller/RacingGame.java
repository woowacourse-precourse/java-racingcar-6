package racingcar.controller;

import racingcar.model.TryCount;
import racingcar.service.CarsService;
import racingcar.view.OutputView;

public class RacingGame {

    private final CarsService carsService;
    private final int tryCount;

    public RacingGame(CarsService carsService, TryCount tryCount) {
        this.carsService = carsService;
        this.tryCount = tryCount.getTryCount();
    }

    public void run() {
        for (int i = 0; i < tryCount; i++) {
            carsService.moveCars();
            OutputView.printCarNameAndPosition(carsService.getCarNamePositionMap());
        }
        OutputView.printVictoryCarNames(carsService.getCarNamesAtPosition(carsService.getMaxPosition()));
    }
}
