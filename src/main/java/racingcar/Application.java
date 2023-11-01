package racingcar;

import racingcar.controller.GameController;
import racingcar.util.RandomNumberGenerator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameController gameController = new GameController(new RandomNumberGenerator());
        gameController.run();
    }
}
