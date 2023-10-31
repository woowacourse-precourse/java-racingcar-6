package racingcar.vo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RacingRoundCountTest {

    @Test
    void RoundCount_생성() {
        RacingRoundCount racingRoundCount = new RacingRoundCount("12");
        Assertions.assertThat(racingRoundCount.value()).isEqualTo(12);
    }

    @Test
    void 같은_VO_동등성_검사() {
        RacingRoundCount racingRoundCount1 = new RacingRoundCount("12");
        RacingRoundCount racingRoundCount2 = new RacingRoundCount("12");
        Assertions.assertThat(racingRoundCount1.value()).isEqualTo(racingRoundCount1.value());
        Assertions.assertThat(racingRoundCount2).isEqualTo(racingRoundCount2);
    }

    @Test
    void 같은_VO_동일성_검사() {
        RacingRoundCount racingRoundCount1 = new RacingRoundCount("12");
        RacingRoundCount racingRoundCount2 = new RacingRoundCount("12");
        Assertions.assertThat(racingRoundCount1).hasSameHashCodeAs(racingRoundCount2);
    }
}
