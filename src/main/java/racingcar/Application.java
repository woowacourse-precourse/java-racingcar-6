package racingcar;

import racingcar.application.GameManager;

public class Application {
    public static void main(final String[] args) {
        final GameManager gameManager = new GameManager();
        gameManager.run();
    }
}
