package racingcar.controller;

import racingcar.CarSpeedGenerator;
import racingcar.Cars;
import racingcar.RacingResult;
import racingcar.RandomSpeedGenerator;
import racingcar.Winners;
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
        final int numberOfAttempts = InputView.readNumberOfAttempts();

        OutputView.printRacingResultTitle();
        for (int attempt = 0; attempt < numberOfAttempts - 1; attempt++) {
            raceWith(cars, speedGenerator);
        }
        return raceWith(cars, speedGenerator);
    }

    private CarSpeedGenerator createSpeedGenerator() {
        return new RandomSpeedGenerator();
    }

    private RacingResult raceWith(final Cars cars, final CarSpeedGenerator speedGenerator) {
        final RacingResult racingResult = cars.race(speedGenerator);
        OutputView.printRacingResult(racingResult);
        return racingResult;
    }
}
