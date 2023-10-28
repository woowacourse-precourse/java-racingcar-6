package racingcar.service;

import java.util.List;
import racingcar.domain.car.Cars;

public class GameService {
    private final Cars cars;
    private final Attempt attempt;
    private Count count;
    private GameState state;

    private GameService(Cars cars, Attempt attempt) {
        this.cars = cars;
        this.attempt = attempt;
        this.count = Count.zero();
        state = GameState.ON;
    }

    public static GameService of(Cars cars, Attempt attempt) {
        return new GameService(cars, attempt);
    }

    public void tryToOff() {
        if (satisfiedEndCondition()) {
            state = GameState.OFF;
        }
    }

    public boolean satisfiedEndCondition() {
        return attempt.getValue() == count.getValue();
    }

    public boolean isOver() {
        return state == GameState.OFF;
    }

    public void moveCars() {
        cars.moveCars();
        count = count.plusOne();
    }

    public List<String> getResults() {
        return cars.getResults();
    }
}
