package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.InputHandler;
import racingcar.domain.Winner;

import java.util.LinkedHashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerTest {
    private LinkedHashMap<String, Integer> sb;

    @BeforeEach
    void setUp() {
        sb = new LinkedHashMap<>();
    }

    @Test
    void qqqWins() {
        sb.put("qqq", 5);
        sb.put("www", 3);
        sb.put("eee", 4);

        assertThat(Winner.findWinner(sb)).isEqualTo("최종 우승자 : qqq");
    }

    @Test
    void multiWinner() {
        sb.put("qqq", 5);
        sb.put("www", 3);
        sb.put("eee", 5);

        assertThat(Winner.findWinner(sb)).isEqualTo("최종 우승자 : qqq, eee");
    }

    @Test
    void allZeroScore() {
        sb.put("qqq", 0);
        sb.put("www", 0);
        sb.put("eee", 0);

        assertThat(Winner.findWinner(sb)).isEqualTo("최종 우승자 : qqq, www, eee");
    }
}
