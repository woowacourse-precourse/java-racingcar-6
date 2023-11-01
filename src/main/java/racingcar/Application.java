package racingcar;

import racingcar.configuration.ApplicationConfiguration;
import racingcar.controller.GameController;

public class Application {
    public static void main(String[] args) {
        ApplicationConfiguration applicationConfiguration = new ApplicationConfiguration();
        GameController gameController = applicationConfiguration.gameController();
        gameController.run();
    }
}
