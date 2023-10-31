package racingcar;

import racingcar.config.RacingCarConfig;
import racingcar.controller.RacingCarController;

public class Application {
    public static void main(String[] args) {

        RacingCarController racingCarController = RacingCarConfig.getRacingCarController();
        racingCarController.play();

    }
}
