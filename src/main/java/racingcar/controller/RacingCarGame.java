package racingcar.controller;

import racingcar.service.CarService;
import racingcar.validator.Validator;
import racingcar.view.InputView;

public class RacingCarGame {

    private final CarService carService;

    public RacingCarGame(CarService carService) {
        this.carService = carService;
    }

    public void run() {
        gameStart();
    }

    private void gameStart() {
        String[] carNameArr = splitCarNames(InputView.carNames());
        Validator.InputCarNames(carNameArr);
        carService.init(carNameArr);
    }

    private String[] splitCarNames(String carNames) {
        return carNames.split(",");
    }
}
