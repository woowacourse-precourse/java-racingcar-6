package racingcar;

import racingcar.controller.RacingController;

public class Application {
    public static void main(String[] args) {
        RacingController racingController = RacingController.getInstance();

        racingController.init();
        while (!racingController.isGameOver()) {
            racingController.updateView();
        }
    }
}
