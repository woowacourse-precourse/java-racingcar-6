package racingcar;

import racingcar.model.Game;

public class GameController {
    Game game;
    GameView gameView;

    public GameController(Game game, GameView gameView) {
        this.game = game;
        this.gameView = gameView;
    }

}
