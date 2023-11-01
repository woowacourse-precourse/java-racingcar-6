package racingcar.controller;

import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void run() {
        Cars cars = inputCarNames();
        int attemptCount = inputAttemptCount();
        race(cars, attemptCount);
        getFinalWinner(cars);
    }

    private void getFinalWinner(Cars cars) {
        outputView.printFinalWinner(cars);
    }

    private void race(Cars cars, int attemptCount) {
        int remainingCount = attemptCount;
        outputView.printResultMessage();
        while (remainingCount > 0) {
            cars.forward();
            outputView.printCarsPosition(cars);
            remainingCount--;
        }
    }

    private int inputAttemptCount() {
        return inputView.inputAttemptCount();
    }

    private Cars inputCarNames() {
        return new Cars(inputView.inputCarNames());
    }
}
