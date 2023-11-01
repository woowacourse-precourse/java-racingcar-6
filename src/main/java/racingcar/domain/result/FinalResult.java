package racingcar.domain.result;

import java.util.List;
import racingcar.domain.car.Car;

public class FinalResult {
    private final List<RoundResult> roundResults;
    private final List<Car> winners;

    public FinalResult(List<RoundResult> roundResults, List<Car> winners) {
        this.roundResults = roundResults;
        this.winners = winners;
    }

    public List<RoundResult> getRoundResults() {
        return roundResults;
    }
    public List<String> getWinnerNames() {
        return winners.stream().map(Car::getName).toList();
    }
}
