package racingcar;

import racingcar.Controller.GameController;

public class Application {
    static GameController gameController;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        gameController = new GameController();

        gameController.play();
    }
}
