package racingcar;

import racingcar.game.Game;
import racingcar.game.GameManager;
import racingcar.game.RacingCarGame;

public class Application {
    public static void main(String[] args) {
        Game game = new RacingCarGame();
        GameManager gameManager = new GameManager(game);
        gameManager.start();
    }
}
