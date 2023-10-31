package racingcar;

import racingcar.controller.Controller;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        Controller controller = appConfig.controller();
        controller.initRacingGame();
    }
}
