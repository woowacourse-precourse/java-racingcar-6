package racingcar;

import racingcar.config.RacingCarGameConfig;

import racingcar.controller.RacingCarGameController;

public class Application {
    public static void main(String[] args) {

        RacingCarGameConfig config = new RacingCarGameConfig();

        RacingCarGameController gameController = config.gameController();
        gameController.play();
    }
}
