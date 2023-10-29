package racingcar;

import controller.RacingCarController;

public class Application {
    public static RacingCarController racingCarController = new RacingCarController();

    public static void main(String[] args) {
        racingCarController.start();
    }
}
