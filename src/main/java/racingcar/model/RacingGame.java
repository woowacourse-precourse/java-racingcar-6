package racingcar.model;

import static java.util.Comparator.comparing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingGame {

    private final List<RoundResult> roundResults;

    private final CarSpeedGenerator generator;

    public RacingGame(final CarSpeedGenerator generator) {
        this.roundResults = new ArrayList<>();
        this.generator = generator;
    }

    public void play(final Cars cars, final TryCount tryCount) {
        for (int round = 1; round <= tryCount.getValue(); round++) {
            cars.moveForward(generator);
            roundResults.add(new RoundResult(round, cars.getScores()));
        }
    }

    public List<RoundResult> getRoundResults() {
        return Collections.unmodifiableList(roundResults);
    }

    public List<RaceScore> getHighScores() {
        final RoundResult finalResult = getFinalResult();
        final int highScore = getHighScore(finalResult);

        return finalResult.getResults().stream()
                .filter(raceScore -> raceScore.score() == highScore)
                .toList();
    }

    private RoundResult getFinalResult() {
        return Collections.max(roundResults, comparing(RoundResult::getRound));
    }

    private static int getHighScore(final RoundResult finalResult) {
        return Collections
                .max(finalResult.getResults(), comparing(RaceScore::score))
                .score();
    }
}
