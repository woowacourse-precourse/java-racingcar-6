package racingcar;

import racingcar.controller.GameController;
import racingcar.service.GameService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        final GameService gameService = new GameService();
        final GameController gameController = new GameController(gameService);
        gameController.run();

    }
}
