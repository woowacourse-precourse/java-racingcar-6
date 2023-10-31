package racingcar;

import racingcar.controller.GameController;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController(new InputView());
        gameController.runGame();
    }
}
