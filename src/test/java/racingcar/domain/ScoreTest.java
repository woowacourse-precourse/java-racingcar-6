package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ScoreTest {
    @Test
    public void 입력받은_만큼_점수가_오른다() {
        Long expect = 100L;
        Score score = new Score("", 50L);
        score.addScore(50L);
        Assertions.assertThat(score.getScore()).isEqualTo(expect);
    }

}