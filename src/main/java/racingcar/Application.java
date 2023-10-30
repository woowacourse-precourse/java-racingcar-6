package racingcar;

import racingcar.configuration.AppConfig;
import racingcar.controller.RacingController;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        RacingController racingController = appConfig.racingController();

        racingController.runGame();
    }
}
