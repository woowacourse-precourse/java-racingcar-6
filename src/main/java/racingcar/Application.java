package racingcar;

import racingcar.controller.RacingController;
import racingcar.util.RacingNumberGenerator;
import racingcar.util.RandomNumberGenerator;

public class Application {
    public static void main(String[] args) {
        RandomNumberGenerator randomNumberGenerator = new RacingNumberGenerator();
        RacingController racingController = new RacingController(randomNumberGenerator);
        racingController.raceStart();
    }
}
