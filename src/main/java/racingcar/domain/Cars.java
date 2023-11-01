package racingcar.domain;

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
        int maxDriveCount = calculateMaxDriveCount();
        List<String> winnerNames = getWinnerNames(maxDriveCount);
        return new WinnerNames(winnerNames);
    }

    private int calculateMaxDriveCount() {
        return cars.stream()
                .map(Car::getStatus)
                .mapToInt(CarStatus::getDriveCount)
                .max()
                .orElse(0);
    }

    private List<String> getWinnerNames(int maxDriveCount) {
        return cars.stream()
                .map(Car::getStatus)
                .filter(carStatus -> carStatus.getDriveCount() == maxDriveCount)
                .map(CarStatus::getName)
                .toList();
    }
}
