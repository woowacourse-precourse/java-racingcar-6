package racingcar.controller;


import racingcar.domain.racingCars;
import racingcar.view.inputView;

public class racingCarGameController {
    private static int raceCount;
    public static void play() {
        racingCars racingCars = new racingCars(inputView.requireRacingCarName());
        raceCount = inputView.requireRacingCount();

        for (int i = 0; i < raceCount; i++) {
            racingCars.race();
        }
    }
}
