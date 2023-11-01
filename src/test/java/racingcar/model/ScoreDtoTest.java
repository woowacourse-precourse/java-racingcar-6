package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ScoreDtoTest {
    @Test
    @DisplayName("ScoreDto가 잘 생성되는지 확인")
    public void createScoreDto() {
        ScoreDto scoreDto = new ScoreDto("pobi", 4);
        assertThat(scoreDto.getName()).isEqualTo("pobi");
        assertThat(scoreDto.getDistance()).isEqualTo(4);
    }

    @Test
    @DisplayName("넘겨받은 거리가 같을 때 true 반환")
    public void isSameDistance() {
        ScoreDto scoreDto = new ScoreDto("pobi", 4);
        assertThat(scoreDto.isSameDistance(4)).isTrue();
    }

}
