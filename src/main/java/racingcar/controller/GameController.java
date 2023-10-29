package racingcar.controller;

import racingcar.model.RacingCarList;
import racingcar.view.*;

import static racingcar.view.OutputView.*;
import static racingcar.view.InputView.*;
public class GameController {
    private final GameProcess process;

    public GameController(){
        process = new GameProcess();
    }
    public void run() {
        String namesOfRacingCars = getPlayerInput();
        RacingCarList car = new RacingCarList(namesOfRacingCars);
        int tryAttempt = getPlayerAttempts();

        gameResultMessge();
        while(tryAttempt > 0){
            process.processGame(car);
            tryAttempt -= 1;
        }
    }
}
