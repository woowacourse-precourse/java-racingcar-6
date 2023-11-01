package racingcar;

import racingcar.controller.GameController;

public class Application {
    public static void main(String[] args) {
        DependencyConfig config = new DependencyConfig();
        GameController gameController = config.gameController();
        gameController.playGame();
    }
}
