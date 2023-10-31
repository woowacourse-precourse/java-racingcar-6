package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.InputHandler;

import java.util.LinkedHashMap;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class InputHandlerTest {
    @Test
    void qqqwwweee() {
        InputHandler input = new InputHandler();
        List<String> names = input.nameToList("qqq,www,eee");
        assertThat(names).isEqualTo(List.of("qqq", "www", "eee"));
    }

    @Test
    void trial5() {
        InputHandler input = new InputHandler();
        int trial = input.trialToInt("5");
        assertThat(trial).isEqualTo(5);
    }

    @Test
    void qqqwwweee_sb() {
        InputHandler input = new InputHandler();
        LinkedHashMap<String, Integer> sb =
                input.generateScoreboard(List.of("qqq", "www", "eee"));
        assertThat(sb.get("qqq")).isEqualTo(0);
        assertThat(sb.get("www")).isEqualTo(0);
        assertThat(sb.get("eee")).isEqualTo(0);
    }
}
