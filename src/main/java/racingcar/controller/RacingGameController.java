package racingcar.controller;

import racingcar.model.CarSpeedGenerator;
import racingcar.model.Cars;
import racingcar.model.RandomSpeedGenerator;
import racingcar.model.Winners;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {

    public void run() {
        final Cars cars = createRacingCars();
        race(cars);
        printWinners(cars);
    }

    private Cars createRacingCars() {
        return Cars.withNames(InputView.readCarNames());
    }

    private void race(final Cars cars) {
        final CarSpeedGenerator speedGenerator = createSpeedGenerator();
        final int numberOfAttempts = readNumberOfAttempts();

        OutputView.printRacingResultTitle();

        for (int attempt = 0; attempt < numberOfAttempts; attempt++) {
            cars.moveForward(speedGenerator);
            OutputView.printRacingResult(cars);
        }
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

    private static void printWinners(final Cars cars) {
        final Winners winners = Winners.from(cars.getMostForwarded());
        OutputView.printWinners(winners);
    }
}
