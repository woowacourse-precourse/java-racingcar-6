package racingcar;

import racingcar.domain.controller.RacingController;

public class Application {
    public static void main(String[] args) {
        RacingController racingController = new RacingController();
        racingController.startRacing();
    }
}