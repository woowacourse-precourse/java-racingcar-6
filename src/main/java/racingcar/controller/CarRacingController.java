package racingcar.controller;

import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarRacingController {
    private OutputView outputView;
    private InputView inputView;
    private Cars cars;

    public CarRacingController() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
        this.cars = new Cars();
    }

}
