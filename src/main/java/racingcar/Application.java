package racingcar;

import racingcar.config.AppConfig;
import racingcar.controller.RaceController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        AppConfig config = new AppConfig();
        RaceController raceController = config.raceController();
        
        raceController.startRace();
    }
}
