package racingcar;

import racingcar.controller.GameManagerController;

public class Application {
    public static void main(String[] args) {
        GameManagerController gameManagerController = new GameManagerController();
        gameManagerController.start();
    }
}
