package racingcar.controller;

import racingcar.service.GameService;

public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    private void init() {
        gameService.readCarNameList();
        gameService.readProgressCount();
    }

    public void start() {
        init();
        gameService.progressGame();
        gameService.finishGame();
    }

}
