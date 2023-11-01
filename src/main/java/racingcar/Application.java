package racingcar;

import racingcar.controller.GameController;
import racingcar.model.GameModel;
import racingcar.view.GameView;

public class Application {
    public static void main(String[] args) {
        GameView gameView = new GameView();
        GameModel gameModel = new GameModel();
        GameController gameController = new GameController(gameModel, gameView);

        gameController.startGame();
    }
}
