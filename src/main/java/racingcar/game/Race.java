package racingcar.game;

import racingcar.domain.Cars;

public class Race {
    private static final int MINIMUM_NUMBER_OF_RACES = 1;
    private static final int MINIMUM_REMAINING_RACES = 0;

    private Cars cars;
    private Integer remainingRaces;

    private Race(Cars cars, Integer numberOfRaces) {
        this.cars = cars;
        this.remainingRaces = numberOfRaces;
    }

    public static Race of(Cars cars, Integer numberOfRaces) {
        validateNumberOfRaces(numberOfRaces);
        return new Race(cars, numberOfRaces);
    }

    private static void validateNumberOfRaces(Integer numberOfRaces) {
        if (numberOfRaces < MINIMUM_NUMBER_OF_RACES) {
            throw new IllegalArgumentException();
        }
    }
}
