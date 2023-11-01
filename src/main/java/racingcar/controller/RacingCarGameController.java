package racingcar.controller;

import racingcar.model.Game;
import racingcar.view.RepeatingGameView;

public class RacingCarGameController implements GameController {
    private final Game game;
    private final RepeatingGameView gameView;
    private boolean playGame;

    public RacingCarGameController(Game game, RepeatingGameView gameView) {
        this.game = game;
        this.gameView = gameView;
    }

    public void race() {
        while (game.continues()) {
            game.play(null);
            gameView.showProgressOf(game);
        }
    }
}
