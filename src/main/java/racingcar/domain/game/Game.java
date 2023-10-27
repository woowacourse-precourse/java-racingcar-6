package racingcar.domain.game;

import racingcar.domain.car.Cars;

public class Game {
    private final Cars cars;
    private final Attempt attempt;
    private Count count;
    private GameState state;

    private Game(Cars cars, Attempt attempt) {
        this.cars = cars;
        this.attempt = attempt;
        this.count = Count.zero();
        state = GameState.ON;
    }

    public static Game of(Cars cars, Attempt attempt) {
        return new Game(cars, attempt);
    }

    public void tryToOff() {
        if (satisfiedEndCondition()) {
            state = GameState.OFF;
        }
    }

    private boolean satisfiedEndCondition() {
        return attempt.getValue() == count.getValue();
    }

    public boolean isOver() {
        return state == GameState.OFF;
    }

    public void moveCars() {
        cars.moveCars();
        count = count.plusOne();
    }
}
