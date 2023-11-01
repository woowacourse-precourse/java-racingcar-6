package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    Cars cars;

    public void startGame() {
        initCars();

        OutputView.printResultStartMessage();
        while (!cars.isTryCountZero()) {
            tryOnce();
        }

        OutputView.printWinnerMessage(cars.findWinner());
    }

    public void initCars() {
        cars = new Cars(InputView.inputCarNames(), InputView.inputTryCount());
    }

    public void tryOnce() {
        cars.moveAllCar();
        OutputView.printScores(cars.getScores());
    }
}
