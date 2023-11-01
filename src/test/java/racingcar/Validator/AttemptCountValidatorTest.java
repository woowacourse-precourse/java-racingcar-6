package racingcar.Validator;

import domain.AttemptCount;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AttemptCountValidatorTest {
    private static final String ZERO_ATTEMPT_COUNT = "0";
    private static final String NEGATIVE_ATTEMPT_COUNT = "-1";
    private static final String NON_INTEGER_ATTEMPT_COUNT = "1.5";
    private static final String CHAR_ATTEMPT_COUNT = "+";

    @Test
    @DisplayName("시도 횟수가 0인 경우")
    void zero_attempt_count_case() {
        Assertions.assertThatThrownBy(() -> new AttemptCount(ZERO_ATTEMPT_COUNT))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("시도 횟수가 음수인 경우")
    void negative_attempt_count_case() {
        Assertions.assertThatThrownBy(() -> new AttemptCount(NEGATIVE_ATTEMPT_COUNT))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("시도 횟수가 정수가 아닌 경우")
    void not_integer_attempt_count_case() {
        Assertions.assertThatThrownBy(() -> new AttemptCount(NON_INTEGER_ATTEMPT_COUNT))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("시도 횟수가 문자인 경우")
    void char_attempt_count_case() {
        Assertions.assertThatThrownBy(() -> new AttemptCount(CHAR_ATTEMPT_COUNT))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
