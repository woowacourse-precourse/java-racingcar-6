package racingcar.controller;

import racingcar.service.GameService;

public class GameController {

    GameService gameService = new GameService();

    public void run() throws  IllegalArgumentException {
        setGame();
        playGame();
    }

    public void setGame(){
        gameService.setGame();
    }

    public void playGame(){
        gameService.playGame();
    }
}
