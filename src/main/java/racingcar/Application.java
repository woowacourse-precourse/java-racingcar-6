package racingcar;

import racingcar.controller.GameManageController;

public class Application {
    public static void main(String[] args) {
        GameManageController gameManage = new GameManageController();
        gameManage.startGame();
    }
}
