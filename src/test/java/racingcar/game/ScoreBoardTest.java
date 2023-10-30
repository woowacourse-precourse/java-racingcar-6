package racingcar.game;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ScoreBoardTest {

    @DisplayName("점수판을 초기화하는 기능 테스트")
    @Test
    public void makeScoreBoardTest() throws Exception {
        //주어진 이름과 빈 StringBuilder 가 들어가 있는지
        List<String> carNames = List.of("cat", "dog", "cow", "human");
        ScoreBoard scoreBoard = new ScoreBoard(carNames);
        Map<String, StringBuilder> testBoard = scoreBoard.getScoreBoard();

        assertEquals(carNames.size(), testBoard.size());

        for (String carName : carNames) {
            assertTrue(testBoard.containsKey(carName));
            assertEquals(0, testBoard.get(carName).length());
        }
    }

    @DisplayName("점수 갱신 기능 테스트")
    @Test
    public void updateScoreTest() throws Exception {
        //given
        List<String> carNames = List.of("cat", "dog", "cow", "human");
        ScoreBoard scoreBoard = new ScoreBoard(carNames);
        scoreBoard.updateScore();

        for (StringBuilder sb : scoreBoard.getScoreBoard().values()) {
            int score = sb.length();
            assertTrue(score == 0 || score == 1);
        }

    }

}