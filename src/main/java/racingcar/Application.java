package racingcar;

import controller.GameController;

public class Application {
    public static void main(String[] args) {

        GameController gameController = new GameController();

        gameController.startGame();
        gameController.numberOfGame();
        gameController.proceedingGame();
        gameController.gameEnding();
    }
}
