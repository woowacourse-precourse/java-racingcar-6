package racingcar.model;

import java.util.Collections;
import java.util.List;

public class RoundResult {

    private final int round;

    private final List<MoveResult> scores;

    public RoundResult(final int round, final List<MoveResult> scores) {
        this.round = round;
        this.scores = scores;
    }

    public List<MoveResult> getResults() {
        return Collections.unmodifiableList(scores);
    }

    public int getRound() {
        return round;
    }
}
