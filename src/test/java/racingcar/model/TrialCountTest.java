package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class TrialCountTest {

    @DisplayName("hasNoCount 테스트 : 시도 횟수가 더이상 남아있지 않다면 true 를 반환한다.")
    @Test
    void hasNoCount() {
        TrialCount trialCount1 = new TrialCount(0);
        TrialCount trialCount2 = new TrialCount(1);

        boolean expectedTrue = trialCount1.hasNoCount();
        boolean expectedFalse = trialCount2.hasNoCount();

        assertAll(
            () -> assertThat(expectedTrue).isTrue(),
            () -> assertThat(expectedFalse).isFalse()
        );
    }

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