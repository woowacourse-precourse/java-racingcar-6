package racingcar;

import racingcar.config.Configuration;

public class Application {
    public static void main(String[] args) {
        Configuration.getGameController().run();
        Configuration.closeResources();
    }
}
