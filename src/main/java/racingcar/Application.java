package racingcar;

import config.Configuration;

public final class Application {
    public static void main(final String[] args) {
        Configuration
                .getDefaultGameController()
                .run();
    }
}
