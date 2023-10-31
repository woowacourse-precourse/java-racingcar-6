package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlayRacingTest {

    private PlayRacing playRacing;

    @BeforeEach
    void setUp() {
        playRacing = new PlayRacing();
    }

    @Test
    void getMaxScore_최대_스코어_계산() {
        String[] scoreList = {"---", "--", "----", "---", "----"};
        int maxScore = playRacing.getMaxScore(scoreList);
        assertThat(maxScore).isEqualTo(4);
    }

    @Test
    void getWinnerList_우승자가_한_명인_경우() {
        String[] carList = {"pobi", "woni", "jun", "winner"};
        String[] scoreList = {"-", "--", "---", "----"};
        String winnerList = playRacing.getWinnerList(carList, scoreList);

        assertThat(winnerList).isEqualTo("최종 우승자 : winner");
    }

    @Test
    void getWinnerList_우승자가_여러_명인_경우() {
        String[] carList = {"pobi", "woni", "jun", "winner"};
        String[] scoreList = {"-", "--", "----", "----"};
        String winnerList = playRacing.getWinnerList(carList, scoreList);

        assertThat(winnerList).isEqualTo("최종 우승자 : jun, winner");

    }
}