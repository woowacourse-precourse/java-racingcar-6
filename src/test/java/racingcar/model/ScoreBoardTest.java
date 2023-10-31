package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ScoreBoardTest {
    @Test
    @DisplayName("스코어보드에 스코어가 잘 입력되는지 확인")
    public void recordScore() {
        ScoreDto pobiScore = new ScoreDto("pobi", 3);
        ScoreDto dobiScore = new ScoreDto("dobi", 4);
        ScoreDto robiScore = new ScoreDto("dobi", 4);
        ScoreBoard scoreBoard = new ScoreBoard();
        scoreBoard.recordScore(1, Arrays.asList(pobiScore, dobiScore, robiScore));
        scoreBoard.recordScore(2, Arrays.asList(pobiScore, dobiScore, robiScore));
        assertThat(scoreBoard.getSize()).isEqualTo(2);
    }

}