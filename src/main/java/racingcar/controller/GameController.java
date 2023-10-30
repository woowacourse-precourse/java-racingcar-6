package racingcar.controller;

import racingcar.service.GameService;

public class GameController {
    private final GameService gameService = new GameService();
    
    public void run() {
        gameService.initGame();
        gameService.playGame();
        gameService.endGame();
    }
}
