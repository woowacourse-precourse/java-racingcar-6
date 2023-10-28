package racingcar.controller;

import racingcar.model.service.GameService;
import racingcar.view.InputView;

public class GameController {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    public void run() {
        int attemptNum = InputView.inputAttempt();
        gameService.createCars();

        while (attemptNum == 0) {
            gameService.playGame();
            attemptNum--;
        }
    }
}
