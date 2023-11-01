package racingcar;

import racingcar.controller.GameEngine;

public class Application {
    public static void main(String[] args) {
        GameEngine gameEngine = new GameEngine();
        gameEngine.proceedGame();
    }
}
