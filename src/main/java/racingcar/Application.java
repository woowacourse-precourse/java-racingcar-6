package racingcar;

import racingcar.controller.GameController;
import racingcar.model.Game;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        Game game = gameController.beforeGameStart();
        gameController.gameStart();
        gameController.gameProceed(game);
        gameController.gameOver(game);
    }
}
