package racingcar;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RaceResultTest {
    RaceResult raceResult = new RaceResult();

    @DisplayName("점수판에서 가장 긴 길이를 찾는 기능 테스트")
    @Test
    void calculateForwardPoint() {
        //given
        Map<String, StringBuilder> scoreBoard = new LinkedHashMap<>();
        scoreBoard.put("cat", new StringBuilder("---"));
        scoreBoard.put("dog", new StringBuilder("--"));
        scoreBoard.put("cow", new StringBuilder("------"));
        scoreBoard.put("eagle", new StringBuilder("-"));
        scoreBoard.put("human", new StringBuilder("--------"));
        //when
        int maxPoint = raceResult.calculateForwardPoint(scoreBoard);
        //then
        assertThat(maxPoint).isEqualTo(8);
    }

    @DisplayName("우승 포인트와 비교하여 우승자를 산출하는 기능 테스트")
    @Test
    void findWinners() {
        Map<String, StringBuilder> scoreBoard = new LinkedHashMap<>();
        scoreBoard.put("cat", new StringBuilder("---"));
        scoreBoard.put("dog", new StringBuilder("--------"));
        scoreBoard.put("cow", new StringBuilder("---"));
        scoreBoard.put("eagle", new StringBuilder("--------"));
        scoreBoard.put("human", new StringBuilder("--------"));

        List<String> winnerList = raceResult.findWinners(8, scoreBoard);
        assertThat(winnerList).isEqualTo(List.of("dog", "eagle", "human"));
    }
}