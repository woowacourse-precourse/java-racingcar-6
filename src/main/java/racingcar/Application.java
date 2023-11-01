package racingcar;

import racingcar.config.RaceConfig;
import racingcar.manager.RaceManager;

public class Application {
    public static void main(String[] args) {

        RaceConfig raceConfig = new RaceConfig();

        RaceManager raceManager = raceConfig.getRaceManager();
        raceManager.start();
    }
}
