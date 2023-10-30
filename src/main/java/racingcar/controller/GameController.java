package racingcar.controller;

import racingcar.service.GameService;

public class GameController {
    GameService gameService = new GameService();

    public void run() {
        gameService.start();
    }
}
