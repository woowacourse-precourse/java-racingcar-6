package racingcar;

import racingcar.controller.RaceController;
import racingcar.service.RandomNumberService;

public class Application {
    public static void main(String[] args) {

        RandomNumberService randomNumberService = new RandomNumberService();
        RaceController raceController = new RaceController(randomNumberService);
        raceController.startGame();

    }
}
