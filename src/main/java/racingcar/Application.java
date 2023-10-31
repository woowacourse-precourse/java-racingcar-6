package racingcar;

import racingcar.Controller.RacingController;

public class Application {
    public static void main(String[] args) {
        RacingController racingController = new RacingController();
        racingController.start();
    }
}
