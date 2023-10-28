package racingcar;

import racingcar.controller.GameController;
import racingcar.view.GameView;

public class Application {

    public static void main(String[] args) {
        GameController gameController = new GameController(new GameView());
        gameController.playGame();
    }
}
