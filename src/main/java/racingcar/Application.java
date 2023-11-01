package racingcar;

import controller.RacingCarGameController;

public class Application {
    private static RacingCarGameController racingCarGameController;
    public static void main(String[] args) {
        racingCarGameController = new RacingCarGameController();
        racingCarGameController.play();
    }
}
