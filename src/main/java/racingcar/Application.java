package racingcar;

import racingcar.controller.RacingcarController;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        RacingcarController racingcarController = appConfig.racingcarController();

        racingcarController.play();
    }
}
