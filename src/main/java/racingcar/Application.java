package racingcar;

import racingcar.controller.GameController;

public class Application {
    public static void main(String[] args) {
        GameController gameController = GameController.getInstance();
        gameController.race();
    }
}
