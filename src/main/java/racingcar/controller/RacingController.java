package racingcar.controller;


import racingcar.service.CarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final CarService carService;
    private int moveCount;

    public RacingController(CarService carService) {
        this.carService = carService;
    }

    public void init() {
        inputCarNames();
        inputMoveCount();
    }

    private void inputCarNames() {
        OutputView.printNameInputDescription();
        try {
            carService.createCars(InputView.inputCarNames());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    private void inputMoveCount() {
        OutputView.printMoveCountInputDescription();
        InputView.inputMoveCount();
    }


}
