package racingcar;

import racingcar.controller.GameStartController;

public class Application {
    public static void main(String[] args) {

        GameStartController gameStartController = new GameStartController();

        gameStartController.gameStart();
    }
}
