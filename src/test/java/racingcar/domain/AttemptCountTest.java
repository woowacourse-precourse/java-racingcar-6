package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import domain.AttemptCount;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AttemptCountTest {
    @Test
    @DisplayName("시도 횟수가 0인 경우")
    void zero_attempt_count_case() {
        Assertions.assertThatThrownBy(() -> new AttemptCount("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("시도 횟수가 음수인 경우")
    void negative_attempt_count_case() {
        Assertions.assertThatThrownBy(() -> new AttemptCount("-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("시도 횟수가 정수가 아닌 경우")
    void not_integer_attempt_count_case() {
        Assertions.assertThatThrownBy(() -> new AttemptCount("1.5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("시도 횟수가 문자인 경우")
    void char_attempt_count_case() {
        Assertions.assertThatThrownBy(() -> new AttemptCount("+"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("시도 횟수 get 메소드")
    void check_getAttemptCount() {
        int expectedCount = 3;
        AttemptCount attemptCount = new AttemptCount("3");

        assertThat(attemptCount.getAttemptCount()).isEqualTo(expectedCount);
    }
}
