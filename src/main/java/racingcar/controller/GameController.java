package racingcar.controller;

import racingcar.model.service.GameService;

public class GameController {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    public void run() {
        gameService.createCars();
        gameService.playGame();
        gameService.resultGame();
    }
}
