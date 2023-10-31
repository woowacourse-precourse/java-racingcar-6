package racingcar;

import racingcar.controller.GameController;
import racingcar.domain.RacingGame;
import racingcar.io.Input;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.initGame();
        gameController.playGame();
        gameController.endGame();
    }
}
