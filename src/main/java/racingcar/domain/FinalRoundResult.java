package racingcar.domain;

import java.util.List;

public class FinalRoundResult {
    private final List<SingleRoundResult> roundResults;
    private final List<Car> winners;

    public FinalRoundResult(List<SingleRoundResult> singleRoundResults, List<Car> winners) {
        this.roundResults = singleRoundResults;
        this.winners = winners;
    }

    public List<SingleRoundResult> getRoundResults() {
        return roundResults;
    }

    public List<String> getWinnerNames() {
        return winners.stream().map(car -> car.getName()).toList();
    }
}
