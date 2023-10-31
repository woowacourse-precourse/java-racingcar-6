package racingcar;

import racingcar.controller.GameController;
import racingcar.utils.RandomNumberGenerator;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController(new RandomNumberGenerator());
        gameController.run();
    }
}
