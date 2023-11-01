package racingcar;

import java.util.Collections;
import java.util.List;

public class RacingResult {

    private final List<RaceScore> scores;

    private RacingResult(final List<RaceScore> scores) {
        this.scores = scores;
    }

    public static RacingResult from(final List<RaceScore> scores) {
        return new RacingResult(scores);
    }

    public List<RaceScore> getScores() {
        return Collections.unmodifiableList(scores);
    }
}
