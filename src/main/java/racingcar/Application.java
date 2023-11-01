package racingcar;

import racingcar.carRacing.controller.CarRacingController;
import racingcar.carRacing.model.CarRacing;

public class Application {
    public static void main(String[] args) {
        CarRacing carRacing = new CarRacing();
        CarRacingController carRacingController = new CarRacingController(carRacing);
        carRacingController.run();
    }
}
