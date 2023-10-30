package racingcar.controller;

import racingcar.domain.RacingGame;
import racingcar.service.CarService;
import racingcar.service.RacingGameService;

public class Controller {
    private final RacingGameService racingGameService;
    private final CarService carService;

    public Controller(RacingGameService racingGameService, CarService carService) {
        this.racingGameService = racingGameService;
        this.carService = carService;
    }

    public void startRacingGame() {
        RacingGame racingGame = racingGameService.createNewGame();
    }
}
