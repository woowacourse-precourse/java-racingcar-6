package racingcar.controller;

import racingcar.service.CarGameService;

public class GameController {

    private CarGameService carGameService;

    public GameController(CarGameService carGameService) {
        this.carGameService = carGameService;
    }

    public void gameRun(String[] carName, Integer gameCount) {
        carGameService.makeAndStoreCar(carName);
        for (int i = 0; i < gameCount; i++) {
            gameStart();
        }
    }

    private void gameStart() {

    }
}
