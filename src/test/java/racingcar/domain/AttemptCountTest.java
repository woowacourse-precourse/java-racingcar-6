package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import domain.AttemptCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AttemptCountTest {
    @Test
    @DisplayName("시도 횟수 get 메소드")
    void check_getAttemptCount() {
        int expectedCount = 3;
        AttemptCount attemptCount = new AttemptCount("3");

        assertThat(attemptCount.getAttemptCount()).isEqualTo(expectedCount);
    }
}
