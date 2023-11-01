package racingcarv2;

import racingcarv2.controller.RacingCarController;

public class MainApplication {
    public static void main(String[] args) {
        RacingCarController racingCarController = new RacingCarController();
        racingCarController.run();
    }
}
