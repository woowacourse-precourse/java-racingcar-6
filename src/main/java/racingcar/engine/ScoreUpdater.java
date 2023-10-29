package racingcar.engine;

import racingcar.domain.Score;
import racingcar.generator.NumberGenerator;

import java.util.List;

public class ScoreUpdater {
    private static final int NUMBER_GENERATOR_START_INCLUSIVE = 0;
    private static final int NUMBER_GENERATOR_END_INCLUSIVE = 9;
    private static final int ADD_SCORE_POINT = 4;
    private static final Long PLUS_SCORE = 1L;
    private final NumberGenerator numberGenerator;

    public ScoreUpdater(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    void updateScore(List<Score> scores) {
        for (Score score : scores) {
            if (numberGenerator.generate(NUMBER_GENERATOR_START_INCLUSIVE, NUMBER_GENERATOR_END_INCLUSIVE) < ADD_SCORE_POINT)
                continue;
            score.addScore(PLUS_SCORE);
        }
    }
}
