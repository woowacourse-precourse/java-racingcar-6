package racingcar.controller;

import racingcar.service.GameService;

public class RacingCarGameController {
    public static void startGame() {
        GameService.runOneGame();
    }
}
