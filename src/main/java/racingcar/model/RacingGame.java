package racingcar.model;

import java.util.List;

public class RacingGame {

    private final Cars cars;
    private final Referee referee;

    public RacingGame(final Cars cars) {
        this.cars = cars;
        this.referee = new Referee();
    }

    public void runOneTerm() {
        cars.move();
    }

    public List<String> getWinners(final Cars cars) {
        referee.decideWinner(cars);
        return referee.getWinnerNames();
    }
}
