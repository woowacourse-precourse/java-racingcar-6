package racingcar.logic;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinnerLogicTest {
    WinnerLogic winnerLogic = new WinnerLogic();

    @Test
    @DisplayName("우승자가 한명 일때")
    void winnerTest1() {
        Map<String, Integer> players = new LinkedHashMap<>();
        players.put("aaa", 5);
        players.put("bbb", 4);
        players.put("ccc", 3);
        List<String> winners = winnerLogic.finalWinner(players);
        assertThat(winners.size()).isEqualTo(1);
        assertThat(winners.contains("aaa")).isTrue();
    }

    @Test
    @DisplayName("우승자가 두명 이상 일때")
    void winnerTest2() {
        Map<String, Integer> players = new LinkedHashMap<>();
        players.put("aaa", 5);
        players.put("bbb", 5);
        players.put("ccc", 3);
        List<String> winners = winnerLogic.finalWinner(players);
        assertThat(winners.size()).isEqualTo(2);
        assertThat(winners.contains("aaa")).isTrue();
        assertThat(winners.contains("bbb")).isTrue();
    }
}