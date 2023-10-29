package racingcar;

import racingcar.controller.GameController;

public class Application {
    public static void main(String[] args) {
        try {
            // TODO: 프로그램 구현
            GameController gameController = new GameController();
            gameController.Init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
