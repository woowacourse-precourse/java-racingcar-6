package racingcar.controller;

import static racingcar.view.InputView.*;
import static racingcar.view.OutputView.*;

import java.util.List;
import racingcar.model.service.GameService;

public class GameController {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    public void run() {
        int attemptNum, idx = 0;
        List<String> carNames = inputName();

        gameService.nameCheck(carNames);
        gameService.createCars(carNames);

        attemptNum = inputAttempt();
        outputResult();

        while (attemptNum != 0) {
            while (idx != carNames.size()) {
                outputForward(gameService.playGame(idx));
                idx++;
            }
            attemptNum--;
        }
        outputWinner(gameService.resultGame());
    }
}
