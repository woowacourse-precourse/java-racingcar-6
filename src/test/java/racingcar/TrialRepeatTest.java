package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.TrialRepeat;

import java.util.Hashtable;
import static org.assertj.core.api.Assertions.assertThat;

public class TrialRepeatTest {
    @Test
    void scoreOf5() {
        Hashtable<String, Integer> sb = new Hashtable<>();
        sb.put("qqq", 0);
        TrialRepeat trial = new TrialRepeat(sb);

        assertThat(trial.personalScore("qqq", true)).isEqualTo("qqq : -");
        assertThat(trial.personalScore("qqq", true)).isEqualTo("qqq : --");
        assertThat(trial.personalScore("qqq", true)).isEqualTo("qqq : ---");
        assertThat(trial.personalScore("qqq", true)).isEqualTo("qqq : ----");
        assertThat(trial.personalScore("qqq", true)).isEqualTo("qqq : -----");
    }
}
