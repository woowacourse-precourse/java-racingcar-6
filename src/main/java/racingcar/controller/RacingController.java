package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.view.InputView;

public class RacingController {
    private Cars cars;

    public void run() {
        String carNames = InputView.getInputCarName();
        this.cars = new Cars(carNames);
    }
}
