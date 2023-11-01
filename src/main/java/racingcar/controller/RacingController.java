package racingcar.controller;

import racingcar.service.RacingService;

public class RacingController {
    private final RacingService game = new RacingService();
    public final void start() {
        game.inputCarName();
        game.inputRacingTime();
        game.makeCar();
        game.racing();
        game.printWinner();
    }
}
