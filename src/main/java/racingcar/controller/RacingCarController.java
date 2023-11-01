package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.RandomMovable;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RandomMovable movable;

    public RacingCarController(InputView inputView, OutputView outputView, RandomMovable movable) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.movable = movable;
    }

    public void start() {
        Cars cars = inputView.inputCars();
        race(cars);
        outputView.printWinner(cars.findWinner());
    }

    private void race(final Cars cars) {
        int round = inputView.inputRound();

        raceRecursive(cars, round);
    }

    private void raceRecursive(final Cars cars, final int remainedTryCount) {
        if (remainedTryCount == 0) {
            return;
        }

        cars.moveAllCars(movable);
        outputView.printMoveResult(cars.toCarsDto());

        raceRecursive(cars, remainedTryCount - 1);
    }
}