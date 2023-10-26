package racingcar.controller;

import racingcar.view.InputView;

public class RacingCarController {
    private final InputView inputView;

    public RacingCarController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        String cars = inputView.readCars();
        String[] names = cars.split(",");
    }
}
