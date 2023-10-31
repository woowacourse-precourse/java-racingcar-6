package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.InputHandler;

import java.util.LinkedHashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class InputHandlerTest {
    private InputHandler input;

    @BeforeEach
    void setUp() {
        input = new InputHandler();
    }

    @Test
    void qqqwwweee() {
        List<String> names = input.nameToList("qqq,www,eee");
        assertThat(names).isEqualTo(List.of("qqq", "www", "eee"));
    }

    @Test
    void trial5() {
        int trial = input.trialToInt("5");
        assertThat(trial).isEqualTo(5);
    }

    @Test
    void qqqwwweee_sb() {
        LinkedHashMap<String, Integer> sb =
                input.generateScoreboard(List.of("qqq", "www", "eee"));
        assertThat(sb.get("qqq")).isEqualTo(0);
        assertThat(sb.get("www")).isEqualTo(0);
        assertThat(sb.get("eee")).isEqualTo(0);
    }
}
