package racingcar;

import racingcar.controller.RaceController;
import racingcar.service.RaceService;

public class Application {
    public static void main(String[] args) {
        RaceService raceService = new RaceService();
        RaceController raceController = new RaceController(raceService);
        raceController.start();
    }
}
