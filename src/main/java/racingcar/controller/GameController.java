package racingcar.controller;

import racingcar.constant.GameConfig;
import racingcar.model.*;

import static racingcar.view.OutputView.*;
import static racingcar.view.InputView.*;

public class GameController {
    private final GameProcess process;
    private final RacingCarResult gameResult;
    private int ZERO = GameConfig.ZERO.getValue();

    public GameController() {
        process = new GameProcess();
        gameResult = new RacingCarResult();
    }

    public void run() {
        String namesOfRacingCars = getPlayerInput();
        RacingCarList car = new RacingCarList(namesOfRacingCars);
        int tryAttempt = getPlayerAttempts();

        gameResultMessge();
        while (tryAttempt > ZERO) {
            process.processGame(car);
            tryAttempt = decreaseAttempt(tryAttempt);
        }
        gameResult.getFinalWinners(car);
        printFinalWinner(gameResult.getWinners());
    }

    private int decreaseAttempt(int attempt) {
        return attempt - 1;
    }

}
