package racingcar;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.game.RaceResult;
import racingcar.game.ScoreBoard;

class RaceResultTest {
    RaceResult raceResult = new RaceResult();

    @DisplayName("점수판에서 가장 긴 길이를 찾는 기능 테스트")
    @Test
    void calculateForwardPoint() {
        //given
        ScoreBoard testBoard = new ScoreBoard(List.of("cat", "dog", "cow", "eagle", "human"));
        testBoard.getScoreBoard().get("cat").append("--");
        testBoard.getScoreBoard().get("dog").append("----");
        testBoard.getScoreBoard().get("cow").append("----");
        testBoard.getScoreBoard().get("eagle").append("-");
        testBoard.getScoreBoard().get("human").append("-------");

        //when
        int maxPoint = raceResult.calculateForwardPoint(testBoard);
        //then
        assertThat(maxPoint).isEqualTo(7);
    }

    @DisplayName("우승 포인트와 비교하여 우승자를 산출하는 기능 테스트")
    @Test
    void findWinners() {
        ScoreBoard testBoard = new ScoreBoard(List.of("cat", "dog", "cow", "eagle", "human"));
        testBoard.getScoreBoard().get("cat").append("--");
        testBoard.getScoreBoard().get("dog").append("-------");
        testBoard.getScoreBoard().get("cow").append("-------");
        testBoard.getScoreBoard().get("eagle").append("------");
        testBoard.getScoreBoard().get("human").append("-------");

        List<String> winnerList = raceResult.findWinners(7, testBoard);
        assertThat(winnerList).isEqualTo(List.of("dog", "cow", "human"));
    }
}