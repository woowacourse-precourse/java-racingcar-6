package racingcar;

import racingcar.controller.GameManageController;

public class Application {
    public static void main(String[] args) {
        GameManageController gameManageController = new GameManageController();
        gameManageController.play();
    }
}
