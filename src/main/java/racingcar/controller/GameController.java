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
        int attemptNum;
        List<String> carNames = inputName();

        gameService.nameCheck(carNames);
        gameService.createCars(carNames);

        attemptNum = inputAttempt();
        outputResult();

        while (attemptNum != 0) {
            play(carNames.size());
            attemptNum--;
        }
        outputWinner(gameService.resultGame());
    }

    private void play(int totalCarCount) {
        int idx = 0;
        while (idx != totalCarCount) {
            outputForward(gameService.playGame(idx));
            idx++;
        }
    }
}
