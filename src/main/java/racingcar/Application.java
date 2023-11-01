package racingcar;

import racingcar.controller.RacingController;
import racingcar.service.RacingService;

public class Application {
    public static void main(String[] args) {
        new ApplicationConfig().racingController().run();
    }
}
