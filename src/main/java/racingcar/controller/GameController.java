package racingcar.controller;

import racingcar.service.GameService;

public class GameController {

    private GameService gameService = new GameService();

    public void gameStart() {
        gameService.play();
    }
}
