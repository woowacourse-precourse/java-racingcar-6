package racingcar;

import racingcar.config.AppConfig;

public class Application {
    public static void main(String[] args) {
        AppConfig racingCarConfig = new AppConfig();
        racingCarConfig.racingCarController().run();
    }
}
