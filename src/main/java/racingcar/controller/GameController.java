package racingcar.controller;

import racingcar.service.GameService;

public class GameController {

    GameService gameService = new GameService();

    public void run() throws  IllegalArgumentException {
        setGame();
    }

    public void setGame(){
        gameService.setGame();
    }
}
