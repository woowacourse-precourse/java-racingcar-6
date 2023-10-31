package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;
import racingcar.dto.CarStatus;
import racingcar.dto.RaceStatus;
import racingcar.dto.WinnerNames;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars createCarsUsingCarNames(List<String> carNames) {
        List<Car> cars = carNames.stream()
                .map(Car::new)
                .toList();

        return new Cars(cars);
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

    public WinnerNames getWinnerNames() {
        List<String> winnerNames = new ArrayList<>();
        int maxDriveCount = 0;

        for (Car car : cars) {
            CarStatus status = car.getStatus();
            int driveCount = status.getDriveCount();

            if (driveCount < maxDriveCount) {
                continue;
            }

            String name = status.getName();

            if (maxDriveCount < driveCount) {
                maxDriveCount = driveCount;
                winnerNames.clear();
            }

            winnerNames.add(name);
        }

        return new WinnerNames(winnerNames);
    }
}
