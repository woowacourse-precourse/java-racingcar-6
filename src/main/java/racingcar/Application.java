package racingcar;

import racingcar.controller.GameController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        final GameController gameController = new GameController();
        gameController.startGame();
    }
}
