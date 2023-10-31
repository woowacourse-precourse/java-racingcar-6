package racingcar;

import racingcar.controller.GameController;
import racingcar.service.GameService;

public class Application {

    public static void main(String[] args) {
        GameController gameController = new GameController(new GameService());
        gameController.start();
    }
}
