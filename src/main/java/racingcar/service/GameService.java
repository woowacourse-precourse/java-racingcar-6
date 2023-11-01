package racingcar.service;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.RacingCars;
import racingcar.domain.AttemptCount;
import racingcar.domain.Winners;
import racingcar.domain.car.Car;
import racingcar.domain.car.DriveStrategy;
import racingcar.domain.car.RandomDriveStrategy;

public class GameService {
    private final RacingCars racingCars;
    private final AttemptCount attemptCount;

    private GameService(RacingCars racingCars, AttemptCount attemptCount) {
        this.racingCars = racingCars;
        this.attemptCount = attemptCount;
    }

    public static GameService startGame(String[] carNames, int attemptCount) {
        DriveStrategy randomDriveStrategy = new RandomDriveStrategy(RandomDriveStrategy::generateRandomNumber);
        List<Car> racingCars = Arrays.stream(carNames)
                .map(carName -> Car.createOnStart(randomDriveStrategy, carName))
                .toList();

        return new GameService(new RacingCars(racingCars), new AttemptCount(attemptCount));
    }

    public boolean isGameProgress() {
        return attemptCount.isProgress();
    }

    public List<Car> attemptDrive() {
        racingCars.driveCars();
        attemptCount.attempt();

        return racingCars.getCars();
    }

    public Winners findWinners() {
        return Winners.create(racingCars.getCars());
    }
}
