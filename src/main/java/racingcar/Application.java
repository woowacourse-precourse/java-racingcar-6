package racingcar;

import racingcar.config.AppConfig;
import racingcar.controller.GameController;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        GameController gameController = appConfig.config();
        gameController.run();
    }
}
