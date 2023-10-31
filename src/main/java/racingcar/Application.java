package racingcar;

import racingcar.config.Configuration;
import racingcar.controller.RacingController;

public class Application {
    public static void main(String[] args) {
        RacingController racingController = Configuration.racingController();

        racingController.run();
    }
}
