package racingcar.controller;

import racingcar.model.CarSpeedGenerator;
import racingcar.model.Cars;
import racingcar.model.RacingResult;
import racingcar.model.RandomSpeedGenerator;
import racingcar.model.Winners;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {

    public void run() {
        final Cars cars = createRacingCars();
        final RacingResult racingResult = race(cars);
        final Winners winners = Winners.from(racingResult.getHighScorePlayers());
        OutputView.printWinners(winners);
    }

    private Cars createRacingCars() {
        return Cars.withNames(InputView.readCarNames());
    }

    private RacingResult race(final Cars cars) {
        final CarSpeedGenerator speedGenerator = createSpeedGenerator();
        final int numberOfAttempts = readNumberOfAttempts();

        OutputView.printRacingResultTitle();
        for (int attempt = 0; attempt < numberOfAttempts - 1; attempt++) {
            raceWith(cars, speedGenerator);
        }
        return raceWith(cars, speedGenerator);
    }

    private CarSpeedGenerator createSpeedGenerator() {
        return new RandomSpeedGenerator();
    }

    private int readNumberOfAttempts() {
        final int numberOfAttempts = InputView.readNumberOfAttempts();

        if (numberOfAttempts <= 0) {
            throw new IllegalArgumentException();
        }
        return numberOfAttempts;
    }

    private RacingResult raceWith(final Cars cars, final CarSpeedGenerator speedGenerator) {
        final RacingResult racingResult = cars.race(speedGenerator);
        OutputView.printRacingResult(racingResult);
        return racingResult;
    }
}
