package racingcar.Controller;

import racingcar.Service.GameService;

public class GameController {
    GameService gameService = new GameService();

    public void run() {
        gameService.initGame();
        gameService.startGame();
        gameService.endGame();
    }
}
