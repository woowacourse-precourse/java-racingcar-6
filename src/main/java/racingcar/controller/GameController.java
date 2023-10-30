package racingcar.controller;

import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public record GameController(InputView inputView, OutputView outputView) {

    public void run() {
        Cars cars = generateCars();
        racing(cars);
    }

    private Cars generateCars() {
        String carNames = inputView.inputCarNames();
        return Cars.from(carNames);
    }

    private void racing(Cars cars) {
        int tryNumber = inputView.inputTryNumber();
        outputView.printResultMessage();
        for (int i = 0; i < tryNumber; i++) {
            cars.race();
            outputView.printResult(cars);
        }
    }
}
