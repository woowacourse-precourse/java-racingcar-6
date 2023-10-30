package racingcar.service;

import java.util.List;
import racingcar.domain.car.Cars;

public class GameService implements Service{
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

    @Override
    public void moveCars() {
        cars.moveCars();
        count = count.plusOne();
    }

    @Override
    public void tryToOff() {
        if (satisfiedEndCondition()) {
            state = GameState.OFF;
        }
    }

    private boolean satisfiedEndCondition() {
        return attempt.getValue() == count.getValue();
    }

    @Override
    public boolean isOver() {
        return state == GameState.OFF;
    }

    @Override
    public List<String> getResults() {
        return cars.getResults();
    }

    @Override
    public List<String> getWinnerNames() {
        return cars.findWinnerNames();
    }
}
