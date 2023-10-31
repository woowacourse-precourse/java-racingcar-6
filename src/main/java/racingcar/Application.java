package racingcar;

import racingcar.controller.CarRacingController;

public class Application {
    public static void main(String[] args) {
        CarRacingController carRacingController = new CarRacingController();
        carRacingController.run();
    }
}
