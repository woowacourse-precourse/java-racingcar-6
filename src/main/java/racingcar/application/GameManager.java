package racingcar.application;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.DefaultFuelFactory;
import racingcar.domain.FuelFactory;
import racingcar.domain.GameTry;
import racingcar.io.InputProcessor;
import racingcar.io.OutputProcessor;

import java.util.List;

public class GameManager {
    private static final FuelFactory FUEL_FACTORY = new DefaultFuelFactory();

    private Cars cars;
    private GameTry gameTry;

    public void run() {
        readRacingCars();
        readGameTryCount();
        racingStart();
        notifyWinners();
    }

    private void readRacingCars() {
        final List<String> participants = InputProcessor.readParticipateCars();
        cars = Cars.from(applyCars(participants));
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
            cars.racing(FUEL_FACTORY);
            OutputProcessor.printRacingRound(cars.getCars());
            gameTry.proceed();
        }
    }

    private void notifyWinners() {
        OutputProcessor.printWinners(cars.getWinners());
    }
}
