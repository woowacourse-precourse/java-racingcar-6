package racingcar;

import racingcar.controller.RacingCarController;

public class Application {
    public static void main(String[] args) {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        RacingCarController controller = new RacingCarController(applicationConfig.racingCarService());
        controller.run();
    }
}
