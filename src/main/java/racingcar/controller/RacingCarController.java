package racingcar.controller;

import java.util.List;
import java.util.Map;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        Cars cars = inputView.inputCars();

        race(cars);

        List<String> winner = cars.findWinner();
        outputView.printWinner(winner);
    }

    private void race(final Cars cars) {
        int tryCount = inputView.inputTryCount();

        raceRecursive(cars, tryCount);
    }

    private void raceRecursive(final Cars cars, final int remainedTryCount) {
        if (remainedTryCount == 0) {
            return;
        }

        Map<Car, Integer> moveResults = cars.moveAllCars();
        outputView.printMoveResult(moveResults);

        raceRecursive(cars, remainedTryCount - 1);
    }
}