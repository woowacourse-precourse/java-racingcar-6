package racingcar.controller;


import racingcar.domain.Game;
import racingcar.service.GameService;

public class Controller {

    GameService gameService = new GameService();

    public void start() {
        gameService.initCarList();
        gameService.runGame();
        gameService.choiceWinner();
    }
}
