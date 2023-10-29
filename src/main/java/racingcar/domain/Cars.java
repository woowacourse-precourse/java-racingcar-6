package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public RaceStatus driveCarsByRule(BooleanSupplier raceRule) {
        List<CarStatus> carStatuses = cars.stream()
                .peek(car -> driveCarAccordingRaceRule(raceRule, car))
                .map(Car::getStatus)
                .toList();

        return new RaceStatus(carStatuses);
    }

    private static void driveCarAccordingRaceRule(BooleanSupplier raceRule, Car car) {
        if (raceRule.getAsBoolean()) {
            car.drive();
        }
    }
}
