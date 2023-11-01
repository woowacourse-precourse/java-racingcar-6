package racingcar.controller;


import racingcar.domain.racingCars;
import racingcar.exception.InvalidRaceCountException;
import racingcar.view.inputView;
import racingcar.view.outputView;

public class racingCarGameController {
    private static int raceCount;
    public static void play() {
        racingCars racingCars = new racingCars(inputView.requireRacingCarName());
        validateRaceCount(inputView.requireRacingCount());

        outputView.printRelayResult();
        for (int i = 0; i < raceCount; i++) {
            racingCars.race();
            outputView.racingCarRelay(racingCars);
        }
        outputView.printWinners(racingCars.calculateWinners());
    }

    private static void validateRaceCount(String raceCountInput) {
        try {
            raceCount = Integer.parseInt(raceCountInput);
        } catch (NumberFormatException error) {
            throw new InvalidRaceCountException();
        }
        if (raceCount <= 0) {
            throw new InvalidRaceCountException();
        }
    }
}
