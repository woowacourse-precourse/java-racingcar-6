package racingcar.controller;

import racingcar.service.game.GameInterface;
import racingcar.service.game.RacingGame;

public class GameController {
    private final GameInterface gameInterface;

    public GameController() {
        this.gameInterface = new RacingGame();
        gameInterface.play();
    }
}
