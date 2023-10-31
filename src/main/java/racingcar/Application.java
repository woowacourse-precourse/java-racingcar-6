package racingcar;

import racingcar.controller.RacingCarGameController;
import racingcar.service.RacingCarGameService;

public class Application {
    public static void main(String[] args) {
        RacingCarGameController racingCarGameController =
                new RacingCarGameController(new RacingCarGameService());
        racingCarGameController.start();
    }
}
