package racingcar.Controller;

import racingcar.Service.GameService;

public class GameController {
    GameService gameService = new GameService();

    public void run() {
        init();
        start();
        end();
    }

    private void init() {
        gameService.enterInput();
    }

    private void start() {
        gameService.forward();
    }

    private void end() {
        gameService.result();
    }
}
