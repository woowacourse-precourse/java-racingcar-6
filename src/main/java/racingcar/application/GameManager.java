package racingcar.application;

import racingcar.domain.Car;
import racingcar.domain.DefaultFuelFactory;
import racingcar.domain.FuelFactory;
import racingcar.domain.GameTry;
import racingcar.domain.RacingStadium;
import racingcar.io.InputProcessor;
import racingcar.io.OutputProcessor;

import java.util.List;

public class GameManager {
    private static final FuelFactory FUEL_FACTORY = new DefaultFuelFactory();

    private RacingStadium racingStadium;
    private GameTry gameTry;

    public void run() {
        readRacingCars();
        readGameTryCount();
        racingStart();
        notifyWinners();
    }

    private void readRacingCars() {
        final List<String> participants = InputProcessor.readParticipateCars();
        racingStadium = RacingStadium.from(applyCars(participants));
    }

    private List<Car> applyCars(final List<String> participants) {
        return participants.stream()
                .map(Car::new)
                .toList();
    }

    private void readGameTryCount() {
        final int attempCount = InputProcessor.readAttemptCount();
        gameTry = GameTry.from(attempCount);
    }

    private void racingStart() {
        while (gameTry.isStillCanTry()) {
            racingStadium.racing(FUEL_FACTORY);
            OutputProcessor.printRacingRound(racingStadium.getCars());
            gameTry.proceed();
        }
    }

    private void notifyWinners() {
        OutputProcessor.printWinners(racingStadium.getWinners());
    }
}
