package racingcar;

import racingcar.domain.GameManager;

public class Application {
    public static void main(String[] args) {
        GameManager gameManager = new GameManager();
        gameManager.run();
    }
}
