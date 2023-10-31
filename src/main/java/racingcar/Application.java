package racingcar;

import racingcar.controller.GameManager;

public class Application {
    public static void main(String[] args) {
        GameManager racingcarGame = new GameManager();
        racingcarGame.runGame();
    }
}
