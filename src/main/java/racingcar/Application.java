package racingcar;

import racingcar.config.AppConfig;
import racingcar.controller.RaceController;

public class Application {

    public static void main(String[] args) {
        RaceController controller = AppConfig.steup();
        controller.run();
    }
}
