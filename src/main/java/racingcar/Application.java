package racingcar;

import racingcar.domain.GameManager;

public class Application {
    static GameManager gameManager;
    public static void main(String[] args) {
        gameManager = new GameManager();
        gameManager.gameStart();
    }
}
