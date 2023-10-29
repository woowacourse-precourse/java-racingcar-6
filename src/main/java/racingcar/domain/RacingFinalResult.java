package racingcar.domain;

import java.util.List;

public class RacingFinalResult {
    private List<RacingRoundResult> roundResults;
    private List<String> winnersName;

    public RacingFinalResult(List<RacingRoundResult> roundResults, List<String> winnersName) {
        this.roundResults = roundResults;
        this.winnersName = winnersName;
    }

    public List<RacingRoundResult> getRoundResults() {
        return roundResults;
    }

    public List<String> getWinnersName() {
        return winnersName;
    }
}
