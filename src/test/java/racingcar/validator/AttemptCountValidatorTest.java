package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class AttemptCountValidatorTest {

    @Test
    void 시도횟수_문자입력_예외발생() {
        String input = "abc";
        assertThatThrownBy(() -> AttemptCountValidator.validateAttemptCount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도횟수_정상입력시_숫자변환() {
        String input = "5";
        int attemptCount = AttemptCountValidator.validateAttemptCount(input);
        assertThat(attemptCount).isEqualTo(5);
    }
}
