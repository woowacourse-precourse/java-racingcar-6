package racingcar;

import racingcar.controller.RacingController;

public class Application {
    private static final RacingController racingController = new RacingController();
    public static void main(String[] args) {
        racingController.gameStart();
    }
}
