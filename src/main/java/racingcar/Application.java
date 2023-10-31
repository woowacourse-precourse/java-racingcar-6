package racingcar;

import controller.GameController;
import controller.UserController;

public class Application {
    public static void main(String[] args) {
        UserController userController = new UserController();
        GameController gameController = new GameController(userController);

        gameController.run();
    }
}
