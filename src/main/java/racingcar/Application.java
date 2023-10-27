package racingcar;

import racingcar.controller.RacingController;

public class Application {

    public static void main(String[] args) {
        AppConfig config = new AppConfig();
        RacingController racingController = config.setController();
        racingController.run();
    }

}
