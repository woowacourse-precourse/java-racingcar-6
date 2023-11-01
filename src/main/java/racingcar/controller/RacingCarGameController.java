package racingcar.controller;

import racingcar.model.Game;
import racingcar.view.RepeatingGameView;

public class RacingCarGameController implements GameController {
    private final Game game;
    private final RepeatingGameView gameView;
    private boolean playGame = true;

    public RacingCarGameController(Game game, RepeatingGameView gameView) {
        this.game = game;
        this.gameView = gameView;
    }

    @Override
    public void quitGame() {
        playGame = false;
    }

    public void race() {
        while (game.continues()) {
            game.play(null);
            gameView.showProgressOf(game);
        }
    }
}
