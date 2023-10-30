package racingcar.controller;

import racingcar.service.GameService;
import racingcar.view.InputAboutGame;
import racingcar.view.OutputAboutGame;

import java.util.List;

public class GameController {
    public GameController() {
        this.run();
    }

    public void run() {
        OutputAboutGame.PrintCarInputPhrase();
        GameService.carsDataSave(InputAboutGame.InputCarNames());
        OutputAboutGame.PrintAttemptInputPhrase();
        GameService.raceDataSave(InputAboutGame.InputAttempt());
    }
}
