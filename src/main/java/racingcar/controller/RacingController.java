package racingcar.controller;

import racingcar.model.Cars;
import racingcar.view.InputView;

public class RacingController {
    InputView inputView = new InputView();

    public void run() {
        Cars cars = inputCarNames();
        int attemptCount = inputAttemptCount();
    }

    private int inputAttemptCount() {
        return inputView.inputAttemptCount();
    }

    private Cars inputCarNames() {
        return new Cars(inputView.inputCarNames());
    }
}
