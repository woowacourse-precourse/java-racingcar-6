package racingcar;

import racingcar.application.RacingCarService;
import racingcar.application.RandomNumberGenerator;
import racingcar.controller.RacingController;
import racingcar.domain.Navigator;

public class Application {
    public static void main(String[] args) {
        RacingController racingController =
                new RacingController(
                        new RacingCarService(new Navigator(new RandomNumberGenerator())));
        racingController.racing();
    }
}
