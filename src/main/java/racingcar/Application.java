package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.service.RacingCarService;

public class Application {
    public static void main(String[] args) {
        RacingCarController racingCarController = new RacingCarController(new RacingCarService());
        racingCarController.start();
    }
}
