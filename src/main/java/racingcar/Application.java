package racingcar;

import racingcar.controller.RacingCarController;

public class Application {

    private static final RacingCarController racingCarController = new RacingCarController();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        racingCarController.playGame();
    }
}
