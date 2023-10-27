package racingcar.controller;


import racingcar.service.CarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private CarService carService;

    public RacingController(CarService carService) {
        this.carService = carService;
    }

    public void init() {
        OutputView.printNameInputDescription();
        String carNames = InputView.inputCarNames();
    }

}
