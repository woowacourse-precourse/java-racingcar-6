package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ScoreTest {
    @Test
    @DisplayName("가장 멀리있는 스코어를 잘 반환하는지 확인")
    public void findFarthestScore() {
        ScoreDto pobiScore = new ScoreDto("pobi", 3);
        ScoreDto dobiScore = new ScoreDto("dobi", 4);
        ScoreDto robiScore = new ScoreDto("dobi", 4);
        Score score = new Score(4, Arrays.asList(pobiScore, dobiScore, robiScore));
        assertThat(score.findFarthestScores()).containsExactly(dobiScore, robiScore);
    }

}