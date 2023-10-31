package racingcar.controller;


import racingcar.domain.racingCars;
import racingcar.view.inputView;
import racingcar.view.outputView;

public class racingCarGameController {
    private static int raceCount;
    public static void play() {
        racingCars racingCars = new racingCars(inputView.requireRacingCarName());
        raceCount = inputView.requireRacingCount();

        outputView.printRelayResult();
        for (int i = 0; i < raceCount; i++) {
            racingCars.race();
            outputView.racingCarRelay(racingCars);
        }
        outputView.printWinners(racingCars.calculateWinners());
    }
}
