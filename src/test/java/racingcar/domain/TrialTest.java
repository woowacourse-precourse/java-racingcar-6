package racingcar.domain;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class TrialTest {
    private Trial trial;

    @Test
    void 숫자_변환_확인() {
        trial = new Trial("30");
        int test = trial.toNum();
        assertThat(test).isEqualTo(30);
    }

}