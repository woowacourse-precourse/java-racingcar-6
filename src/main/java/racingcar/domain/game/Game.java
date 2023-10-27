package racingcar.domain.game;

import racingcar.domain.car.Cars;

public class Game {
    private final Cars cars;
    private final Attempt attempt;
    private GameState state;

    private Game(Cars cars, Attempt attempt) {
        this.cars = cars;
        this.attempt = attempt;
        state = GameState.ON;
    }

    public static Game of(Cars cars, Attempt attempt) {
        return new Game(cars, attempt);
    }

    public void off() {
        state = GameState.OFF;
    }

    public boolean isOver() {
        return state == GameState.OFF;
    }

    public void moveCars() {
        cars.moveCars();
    }
}
