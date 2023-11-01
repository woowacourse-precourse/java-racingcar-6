package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class RefereeTest {

    @DisplayName("무작위 값이 4 이상이면 true를 반환한다.")
    @Test
    void testTryOutcomeTrue() {
        List<String> names = Arrays.asList("pobi", "woni", "jun");
        Referee referee = new Referee();
        List<Integer> randomNumbers = Arrays.asList(3, 4, 5);
        Map<String, Boolean> tryOutcome = referee.checkTryOutcome(names, randomNumbers);
        assertThat(tryOutcome.get("woni")).isEqualTo(true);
    }

    @DisplayName("무작위 값이 4 미만이면 false를 반환한다.")
    @Test
    void testTryOutcomeFalse() {
        List<String> names = Arrays.asList("pobi", "woni", "jun");
        Referee referee = new Referee();
        List<Integer> randomNumbers = Arrays.asList(3, 4, 5);
        Map<String, Boolean> tryOutcome = referee.checkTryOutcome(names, randomNumbers);
        assertThat(tryOutcome.get("pobi")).isEqualTo(false);
    }

    @DisplayName("가장 많이 전진한 자동차는 우승자가 된다.")
    @Test
    void testMaxMovedCarBecomeWinner() {
        Map<String, Integer> moveResult = Map.of("pobi", 3, "woni", 4, "jun", 5);
        Referee referee = new Referee();
        List<String> winnerResult = referee.checkWinner(moveResult);
        assertThat(winnerResult).containsOnly("jun");
    }

    @DisplayName("우승자는 한 명 이상일 수 있다.")
    @Test
    void testMultipleWinners() {
        Map<String, Integer> moveResult = Map.of("pobi", 9, "woni", 9, "jun", 5);
        Referee referee = new Referee();
        List<String> winnerResult = referee.checkWinner(moveResult);
        assertThat(winnerResult).containsOnly("pobi", "woni");
    }
}