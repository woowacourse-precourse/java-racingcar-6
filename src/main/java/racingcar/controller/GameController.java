package racingcar.controller;

import racingcar.service.GameService;

public class GameController {
    private final GameService gameService;

    public GameController() {
        this.gameService = new GameService();
    }

    public void startGame(){
        gameService.startGame();
    }
}
