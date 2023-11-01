package racingcar;

import racingcar.configuration.AppConfig;
import racingcar.configuration.Config;
import racingcar.controller.RacingGameController;

public class Application {
    public static void main(String[] args) {
        Config config = generateConfig();
        RacingGameController racingGameController = generateRacingController(config);
        racingGameController.playGame();
    }

    /**
     * IoC Container를 생성합니다.
     * @return IoC Container
     */
    private static Config generateConfig() {
        return AppConfig.getInstance();
    }

    /**
     * IoC Container에서 racingController객체를 꺼냅니다.
     */
    private static RacingGameController generateRacingController(Config config) {
        return config.racingController();
    }
}