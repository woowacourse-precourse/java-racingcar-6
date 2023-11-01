package racingcar;

import racingcar.controller.RacingController;
import racingcar.model.Cars;

public class Application {
    public static void main(String[] args) {

        RacingController racingController = new RacingController();
        racingController.runGame();
    }
}
