package racingcar;

import racingcar.controller.RacingController;
import racingcar.service.RaceService;

public class Application {
    public static void main(String[] args) {
        RacingController racingController = new RacingController(new RaceService());
        racingController.run();
    }
}
