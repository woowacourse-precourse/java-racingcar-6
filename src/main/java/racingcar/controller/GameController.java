package racingcar.controller;

import racingcar.view.InputAboutGame;
import racingcar.view.OutputAboutGame;

import java.util.List;

public class GameController {
    public GameController() {
        this.run();
    }

    public void run() {
        OutputAboutGame.PrintGameStartPhrase();
        InputAboutGame.InputCarNames();
    }
}
