package racingcar;

import racingcar.controllers.RaceController;

public class Application {
    public static void main(String[] args) {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        RaceController raceController = applicationConfig.raceController();
        raceController.progress();
    }
}
