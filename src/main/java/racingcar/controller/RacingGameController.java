package racingcar.controller;

import racingcar.service.CarService;

public class RacingGameController {
    CarService carService = new CarService();

    public void gameStart() {
        carService.getCarNameAndTryCount();
    }
}
