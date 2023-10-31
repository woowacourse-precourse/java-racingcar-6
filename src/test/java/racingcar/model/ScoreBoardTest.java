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

    @Test
    @DisplayName("스코어보드의 라운드에 따른 스코어 리스트를 잘 반환하는지 확인")
    public void getScoreForRound() {
        ScoreDto pobiScore = new ScoreDto("pobi", 3);
        ScoreDto dobiScore = new ScoreDto("dobi", 4);
        ScoreDto robiScore = new ScoreDto("dobi", 4);
        ScoreBoard scoreBoard = new ScoreBoard();
        scoreBoard.recordScore(1, Arrays.asList(pobiScore, dobiScore));
        scoreBoard.recordScore(2, Arrays.asList(pobiScore, dobiScore, robiScore));

        assertThat(scoreBoard.getScoreForRound(1)).containsExactly(pobiScore, dobiScore);
        assertThat(scoreBoard.getScoreForRound(2)).containsExactly(pobiScore, dobiScore, robiScore);
    }

}