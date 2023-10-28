package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class TrialCountTest {

    @DisplayName("countDown 테스트 : 시도 횟수를 하나 감소시킨다.")
    @Test
    void countDown() {
        TrialCount trialCount = new TrialCount(5);

        trialCount.countDown();

        assertThat(trialCount).usingRecursiveComparison()
                .comparingOnlyFields("count")
                .isEqualTo(new TrialCount(4));

    }
}