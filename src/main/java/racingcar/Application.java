package racingcar;

import racingcar.controller.GameController;
import racingcar.service.GameService;
import racingcar.view.GameView;

public class Application {

    public static void main(String[] args) {
        GameController gameController = new GameController(new GameView(), new GameService());
        gameController.playGame();
    }
}
