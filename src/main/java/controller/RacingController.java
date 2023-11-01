package controller;

import domain.Cars;
import view.InputView;
import view.OutputView;

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
