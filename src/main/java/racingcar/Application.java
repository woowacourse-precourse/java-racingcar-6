package racingcar;

import racingcar.controller.RacingController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingController racingController = RacingController.createCarController();

        racingController.welcome();

        racingController.registerRacer();

        racingController.setRacingCount();

        racingController.startRacing();

        racingController.inRacing();

        racingController.endRacing();
    }
}
