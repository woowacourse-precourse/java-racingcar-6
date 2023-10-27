package racingcar.controller;


import racingcar.service.CarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final CarService carService;

    public RacingController(CarService carService) {
        this.carService = carService;
    }

    public void init() {
        OutputView.printNameInputDescription();
        try {
            carService.createCars(InputView.inputCarNames());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw e;
        }

    }

}
