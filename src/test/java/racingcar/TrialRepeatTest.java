package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.TrialRepeat;

import java.util.LinkedHashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class TrialRepeatTest {
    @Test
    void scoreOf5() {
        LinkedHashMap<String, Integer> sb = new LinkedHashMap<>();
        sb.put("qqq", 0);
        TrialRepeat trial = new TrialRepeat(sb);

        assertThat(trial.personalScore("qqq", true)).isEqualTo("qqq : -");
        assertThat(trial.personalScore("qqq", true)).isEqualTo("qqq : --");
        assertThat(trial.personalScore("qqq", true)).isEqualTo("qqq : ---");
        assertThat(trial.personalScore("qqq", true)).isEqualTo("qqq : ----");
        assertThat(trial.personalScore("qqq", true)).isEqualTo("qqq : -----");
    }
}
