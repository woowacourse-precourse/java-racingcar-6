package racingcar;

import racingcar.config.RacingConfig;
import racingcar.controller.RacingController;

public class Application {

    public static void main(String[] args) {
        final RacingController controller = RacingConfig.getRacingController();
        controller.run();
    }
}
