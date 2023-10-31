package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.domain.RandomNumberGenerator;

public class Application {
    public static void main(String[] args) {
        RacingCarController racingCarController = new RacingCarController(new RandomNumberGenerator());
        racingCarController.run();
    }
}
