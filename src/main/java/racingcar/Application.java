package racingcar;

import racingcar.game.GameManager;

public class Application {
    public static void main(String[] args) {
        GameManager gameManager = new GameManager();

        gameManager.start();
    }
}
