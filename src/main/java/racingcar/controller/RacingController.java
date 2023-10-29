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
    }

    private void race(Cars cars, int attemptCount) {
        outputView.printResultMessage();
        while (attemptCount > 0) {
            cars.forward();
            outputView.printCarsPosition(cars);
            attemptCount--;
        }
    }

    private int inputAttemptCount() {
        return inputView.inputAttemptCount();
    }

    private Cars inputCarNames() {
        return new Cars(inputView.inputCarNames());
    }
}
