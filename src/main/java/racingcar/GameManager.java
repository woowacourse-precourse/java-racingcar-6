package racingcar;

import racingcar.controller.GameController;

public class GameManager {
    private final GameController gameController;

    public GameManager(GameController gameController) {
        this.gameController = gameController;
    }

    public void run() {
        gameController.setUp();
        gameController.playGame();
        gameController.showResult();
        gameController.gameOver();
    }
}
