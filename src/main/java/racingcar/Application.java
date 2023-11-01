package racingcar;

import racingcar.controller.RacingGameController;

public class Application {
    private static final RacingGameController racingGameController = new RacingGameController();

    public static void main(String[] args) {
        racingGameController.run();
    }
}
