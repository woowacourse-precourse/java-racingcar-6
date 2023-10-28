package racingcar.controller;

import racingcar.service.CarService;

public class RacingGameController {
    CarService carService = new CarService();

    public void gameStart() {
        int tryCount = carService.getCarNameAndTryCount();

        for (int i = 0; i < tryCount; i++) {
            carService.game();
        }
    }
}
