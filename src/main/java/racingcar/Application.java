package racingcar;

import racingcar.controller.GameController;

public class Application {
    public static GameController gameController;
    public static void main(String[] args) {
         gameController =new GameController();
        gameController.startGame();
    }
}
