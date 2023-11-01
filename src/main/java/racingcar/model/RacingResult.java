package racingcar.model;

import static java.util.Comparator.comparing;

import java.util.ArrayList;
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

    public List<RaceScore> getHighScorePlayers() {
        final RaceScore highScore = getHighScore();
        final List<RaceScore> highScores = new ArrayList<>();

        for (final RaceScore score : scores) {
            if (score.match(highScore)) {
                highScores.add(score);
            }
        }
        return highScores;
    }

    private RaceScore getHighScore() {
        return Collections.max(scores, comparing(RaceScore::score));
    }
}
