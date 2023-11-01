package racingcar.controller;

import racingcar.model.Game;
import racingcar.view.GameView;

public class RacingCarGameController implements GameController {
    private final Game game;
    private final GameView gameView;
    private boolean playGame;

    public RacingCarGameController(Game game, GameView gameView) {
        this.game = game;
        this.gameView = gameView;
    }
}
