package racingcar;

import racingcar.controller.RacingCarController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingCarController gameController = new RacingCarController();
        gameController.runGame();
    }
}
