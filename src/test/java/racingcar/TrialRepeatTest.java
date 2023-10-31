package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.TrialRepeat;

import java.util.Hashtable;
import static org.assertj.core.api.Assertions.assertThat;

public class TrialRepeatTest {
    @Test
    void scoreOf5() {
        TrialRepeat trial = new TrialRepeat();
        trial.sb = new Hashtable<>();
        trial.sb.put("qqq", 0);

        assertThat(trial.personalScore("qqq", true)).isEqualTo("qqq : -");
        assertThat(trial.personalScore("qqq", true)).isEqualTo("qqq : --");
        assertThat(trial.personalScore("qqq", true)).isEqualTo("qqq : ---");
        assertThat(trial.personalScore("qqq", true)).isEqualTo("qqq : ----");
        assertThat(trial.personalScore("qqq", true)).isEqualTo("qqq : -----");
    }
}
