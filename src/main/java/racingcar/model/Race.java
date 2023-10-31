package racingcar.model;

import java.util.List;

public class Race {
    private int numberOfRace;

    private Race(final int numberOfRace) {
        validateNumberOfRace(numberOfRace);
        this.numberOfRace = numberOfRace;
    }

    public static Race from(final int numberOfRace) {
        return new Race(numberOfRace);
    }

    private void validateNumberOfRace(final int numberOfRace) {
        if (numberOfRace > RaceLimits.MAXIMUM.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.TOO_MUCH_NUMBER_OF_RACE.getMessage());
        }
        if (numberOfRace < RaceLimits.MINIMUM.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.TOO_LITTLE_NUMBER_OF_RACE.getMessage());
        }
    }

    public void runSingleRace(final List<Car> cars) {
        cars.stream()
                .filter(car -> Generator.generateRandomNumber() >= RaceLimits.REFERENCE_NUMBER.getValue())
                .forEach(Car::moveForward);
        this.numberOfRace--;
    }

    public final boolean isRunning() {
        return this.numberOfRace > RaceLimits.FINISH.getValue();
    }
}
