package racingcar;

import racingcar.controller.GameManager;

public class Application {
    public static GameManager gameManager;
    public static void main(String[] args) {
        gameManager = new GameManager();
        gameManager.startRacingGame();
    }
}
