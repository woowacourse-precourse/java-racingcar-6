package racingcar.domain.race;

import racingcar.domain.car.Cars;
import racingcar.domain.policy.DriveRule;

public class Race {
    private final DriveRule driveRule;

    public Race(DriveRule driveRule) {
        this.driveRule = driveRule;
    }

    public void run(Cars cars) {
        cars.move(driveRule);
    }
}