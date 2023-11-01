package racingcar;

import racingcar.controller.GameController;
import racingcar.service.GameService;
import racingcar.service.InputService;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController(new InputService(), new GameService());
        gameController.startGame();
    }
}
