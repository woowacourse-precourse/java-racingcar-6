package racingcar;

import racingcar.module.api.GameController;

public class Application {
    public static void main(String[] args) {
        GameController controller = GameController.getInstance();
        controller.run();
    }
}
