package racingcar.domain;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static racingcar.exception.ExceptionMessage.CarException.DUPLICATE_CAR;
import static racingcar.exception.ExceptionMessage.CarException.NO_PARTICIPANTS;
import static racingcar.exception.ExceptionMessage.WinnerException.WINNER_MUST_BE_EXISTS;

public class RacingStadium {
    private final List<Car> cars;

    private RacingStadium(final List<Car> cars) {
        this.cars = cars;
    }

    public static RacingStadium from(final List<Car> cars) {
        validateParticipantExists(cars);
        validateDuplicateCarExists(cars);
        return new RacingStadium(cars);
    }

    private static void validateParticipantExists(final List<Car> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException(NO_PARTICIPANTS.message);
        }
    }

    private static void validateDuplicateCarExists(final List<Car> cars) {
        if (hasDuplicateCar(cars)) {
            throw new IllegalArgumentException(DUPLICATE_CAR.message);
        }
    }

    private static boolean hasDuplicateCar(final List<Car> cars) {
        return cars.stream()
                .distinct()
                .count() != cars.size();
    }

    public void racing(final FuelFactory fuelFactory) {
        for (final Car car : cars) {
            final int fuel = fuelFactory.get();
            car.moveForward(fuel);
        }
    }

    public List<Car> getWinners() {
        final Position maxPosition = extractMaxPosition();

        return cars.stream()
                .filter(car -> car.isSamePosition(maxPosition))
                .toList();
    }

    private Position extractMaxPosition() {
        return cars.stream()
                .max(Comparator.comparing(Car::getPosition))
                .orElseThrow(() -> new IllegalArgumentException(WINNER_MUST_BE_EXISTS.message))
                .getPosition();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
