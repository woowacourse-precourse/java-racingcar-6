package racingcar.domain;

import java.util.List;
import java.util.function.BooleanSupplier;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void doRace(BooleanSupplier raceRule) {
        for (Car car : cars) {
            driveCarAccordingRaceRule(raceRule, car);
        }
    }

    private static void driveCarAccordingRaceRule(BooleanSupplier raceRule, Car car) {
        if (raceRule.getAsBoolean()) {
            car.drive();
        }
    }


}
