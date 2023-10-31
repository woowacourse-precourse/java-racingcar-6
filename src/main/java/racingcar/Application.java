package racingcar;

import racingcar.game.GameController;

public class Application {

    public static void main(String[] args) {
        GameController controller = new GameController();
        controller.setup();
        controller.start();
    }
}

