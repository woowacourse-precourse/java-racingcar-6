package racingcar;

import racingcar.configuration.AppConfig;
import racingcar.configuration.Config;
import racingcar.controller.RacingController;

public class Application {
    public static void main(String[] args) {
        Config config = generateConfig();
        RacingController racingController = generateRacingController(config);
        racingController.playGame();
    }

    private static Config generateConfig() {
        return AppConfig.getInstance();
    }

    private static RacingController generateRacingController(Config config) {
        return config.racingController();
    }
}
