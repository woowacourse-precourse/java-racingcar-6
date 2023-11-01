package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LeaderboardTest {

    @Test
    void winnerFormat_1명(){
        Leaderboard board = new Leaderboard(Arrays.asList(""));
        String result = board.winnerFormat(Arrays.asList("Kim"));
        assertThat(result).isEqualTo("최종 우승자 : Kim");
    }

    @Test
    void winnerFormat_2명_이상(){
        Leaderboard board = new Leaderboard(Arrays.asList(""));
        String result = board.winnerFormat(Arrays.asList("Kim","Jin","Yi"));
        assertThat(result).isEqualTo("최종 우승자 : Kim, Jin, Yi");
    }

}