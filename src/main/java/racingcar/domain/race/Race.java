package racingcar.domain.race;

import racingcar.domain.car.Car;
import racingcar.domain.policy.DriveRule;
import racingcar.application.RandomDriveRule;

import java.util.List;

public class Race {
    private final DriveRule driveRule;

    public Race(RandomDriveRule randomDriveRule) {
        this.driveRule = randomDriveRule;
    }

    public void run(List<Car> cars) {
        cars.forEach(car ->
                car.move(driveRule));
    }
}