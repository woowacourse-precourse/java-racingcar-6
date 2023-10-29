package racingcar.controller;

import racingcar.model.service.GameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    public void run() {
        gameService.createCars(InputView.inputName());
        gameService.nameCheck();
        OutputView.outputResult();
        gameService.playGame(InputView.inputAttempt());
        OutputView.outputWinner(gameService.resultGame());
    }
}
