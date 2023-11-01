package racingcar;

import racingcar.controller.RacingPlayController;

public class Application {
    public static void main(String[] args) {
        RacingPlayController racingPlayController = new RacingPlayController();
        racingPlayController.play();
    }
}
