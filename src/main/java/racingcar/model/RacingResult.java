package racingcar.model;

import java.util.List;
import racingcar.model.winnerstrategy.WinnerStrategy;

public class RacingResult {
    private final Cars cars;
    private final WinnerStrategy winnerStrategy;

    public RacingResult(Cars cars, WinnerStrategy winnerStrategy) {
        this.cars = cars;
        this.winnerStrategy = winnerStrategy;
    }

    public List<String> getWinnerNames() {
        return winnerStrategy.determineWinner(cars);
    }
}
