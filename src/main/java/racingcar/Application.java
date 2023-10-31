package racingcar;

import racingcar.domain.AppConfig;

public class Application {
    public static void main(String[] args) {
        AppConfig.getController().process();
    }
}
