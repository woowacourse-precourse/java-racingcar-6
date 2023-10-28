package racingcar.game;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.strategy.MoveStrategy;

public class Race {
    private static final int MINIMUM_NUMBER_OF_RACES = 1;
    private static final int MINIMUM_REMAINING_RACES = 0;

    private Cars cars;
    private Integer remainingRaces;
    private MoveStrategy moveStrategy;

    private Race(Cars cars, Integer numberOfRaces, MoveStrategy moveStrategy) {
        validateNumberOfRaces(numberOfRaces);

        this.cars = cars;
        this.remainingRaces = numberOfRaces;
        this.moveStrategy = moveStrategy;
    }

    public static Race of(Cars cars, Integer numberOfRaces, MoveStrategy moveStrategy) {
        return new Race(cars, numberOfRaces, moveStrategy);
    }

    public void performRaceStep() {
        if (!hasRemainingRaces()) {
            throw new IllegalStateException();
        }

        for (Car car : cars) {
            if (moveStrategy.shouldMove()) {
                car.moveForward();
            }
        }

        remainingRaces--;
    }

    public List<Car> determineWinners() {
        if (hasRemainingRaces()) {
            throw new IllegalStateException();
        }
        return cars.getCarsWithMaxStep();
    }

    public boolean hasRemainingRaces() {
        return remainingRaces > MINIMUM_REMAINING_RACES;
    }

    public Cars getCars() {
        return cars;
    }

    private static void validateNumberOfRaces(Integer numberOfRaces) {
        if (numberOfRaces < MINIMUM_NUMBER_OF_RACES) {
            throw new IllegalArgumentException();
        }
    }
}
