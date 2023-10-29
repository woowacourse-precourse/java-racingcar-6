package racingcar.domain;

import java.util.List;

public class FinalResult {
    private final List<SingleRoundResult> singleRoundResults;
    private final List<String> winnerNames;

    public FinalResult(List<SingleRoundResult> singleRoundResults, List<String> winnersNames) {
        this.singleRoundResults = singleRoundResults;
        this.winnerNames = winnersNames;
    }

    public List<SingleRoundResult> getSingleRoundResults() {
        return singleRoundResults;
    }
    public List<String> getWinnerNames() {
        return winnerNames;
    }
}
