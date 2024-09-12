package mytest;

import org.junit.jupiter.api.Test;
import racingcar.RacingScoreBoard;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RacingScoreBoardTest {
    private final RacingScoreBoard scoreBoard = new RacingScoreBoard("car1,car2");

    @Test
    void 이름_입력후_score_초기화() {
        Map<String, Integer> scores = scoreBoard.currentScores();
        assertEquals(0, scores.get("car1"));
        assertEquals(0, scores.get("car2"));
    }

    @Test
    void 자동차_score_증가() {
        scoreBoard.moveCar("car1");
        assertEquals(1, scoreBoard.currentScores().get("car1"));
    }
}
