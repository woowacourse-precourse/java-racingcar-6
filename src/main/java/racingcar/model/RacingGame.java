package racingcar.model;

import java.util.List;

public class RacingGame {

    private final Cars cars;
    private final Referee referee;

    public RacingGame(final Cars cars, final Referee referee) {
        this.cars = cars;
        this.referee = referee;
    }

    public void runOneTerm() {
        cars.move();
    }

    public List<String> getWinners() {
        referee.decideWinner(cars);
        return referee.getWinnerNames();
    }
}
