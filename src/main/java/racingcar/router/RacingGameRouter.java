package racingcar.router;

import racingcar.application.RacingProcessor;
import racingcar.domain.Car;
import racingcar.domain.DefaultFuelFactory;
import racingcar.domain.FuelFactory;
import racingcar.domain.GameTry;
import racingcar.domain.RacingStadium;
import racingcar.io.InputProcessor;

import java.util.List;

public class RacingGameRouter {
    public void invoke() {
        final RacingStadium racingStadium = readRacingCars();
        final GameTry gameTry = readGameTryCount();

        final FuelFactory fuelFactory = new DefaultFuelFactory();
        final RacingProcessor racingProcessor = new RacingProcessor(racingStadium, gameTry, fuelFactory);
        racingProcessor.run();
    }

    private RacingStadium readRacingCars() {
        final List<String> participants = InputProcessor.readParticipateCars();
        return RacingStadium.from(applyCars(participants));
    }

    private List<Car> applyCars(final List<String> participants) {
        return participants.stream()
                .map(Car::new)
                .toList();
    }

    private GameTry readGameTryCount() {
        final int attempCount = InputProcessor.readAttemptCount();
        return GameTry.from(attempCount);
    }
}
