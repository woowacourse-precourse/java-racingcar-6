package racingcar.controller;

import racingcar.model.Cars;
import racingcar.view.InputView;

public record GameController(InputView inputView) {

    public void run() {
        Cars cars = generateCars();
    }

    private Cars generateCars() {
        String carNames = inputView.inputCarNames();
        return Cars.from(carNames);
    }
}
