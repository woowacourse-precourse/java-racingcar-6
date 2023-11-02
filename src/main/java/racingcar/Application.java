package racingcar;

import racingcar.config.AppConfig;
import racingcar.game.Launcher;

public class Application {

    private static final AppConfig appConfig = new AppConfig();


    public static void main(String[] args) {
        Launcher launcher = appConfig.launcher();
        launcher.StartGameLauncher();
    }
}
