package racingcar.vo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RoundCountTest {

    @Test
    void RoundCount_생성() {
        RoundCount roundCount = new RoundCount("12");
        Assertions.assertThat(roundCount.getValue()).isEqualTo(12);
    }

    @Test
    void 같은_VO_동등성_검사() {
        RoundCount roundCount1 = new RoundCount("12");
        RoundCount roundCount2 = new RoundCount("12");
        Assertions.assertThat(roundCount1.getValue()).isEqualTo(roundCount1.getValue());
        Assertions.assertThat(roundCount2).isEqualTo(roundCount2);
    }

    @Test
    void 같은_VO_동일성_검사() {
        RoundCount roundCount1 = new RoundCount("12");
        RoundCount roundCount2 = new RoundCount("12");
        Assertions.assertThat(roundCount1).hasSameHashCodeAs(roundCount2);
    }
}
