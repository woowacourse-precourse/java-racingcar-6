package racingcar.unit.validator;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static tdd.config.ErrorMessage.ATTEMPT_COUNT_ERROR_MESSAGE;

import org.junit.jupiter.api.Test;
import tdd.validator.AttemptCountValidator;

public class AttemptCountValidatorTest {
    private void assertExceptionTest(String errorMessage, String input) {
        assertThatThrownBy(() -> AttemptCountValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(errorMessage);
    }

    private void assertNotThrowExceptionTest(String count) {
        assertThatCode(() -> AttemptCountValidator.validate(count))
                .doesNotThrowAnyException();
    }
    @Test
    void 시도_횟수가_범위_안이면_예외처리_발생_안해서_통과() {
        assertNotThrowExceptionTest("1");
        assertNotThrowExceptionTest("1000");
    }

    @Test
    void 시도_횟수가_1_미만이면_예외처리_발생해서_통과() {
        assertExceptionTest(ATTEMPT_COUNT_ERROR_MESSAGE.getMessage(), "-1");
    }

    @Test
    void 시도_횟수가_1000_이상이면_예외처리_발생해서_통과() {
        assertExceptionTest(ATTEMPT_COUNT_ERROR_MESSAGE.getMessage(), "1001");
    }

    @Test
    void 시도_횟수가_자연수가_아니면_예외처리_발생해서_통과() {
        assertExceptionTest(ATTEMPT_COUNT_ERROR_MESSAGE.getMessage(), "1.0");
    }

    @Test
    void 시도_횟수가_숫자가_아니면_예외처리_발생해서_통과() {
        assertExceptionTest(ATTEMPT_COUNT_ERROR_MESSAGE.getMessage(), "1a");
        assertExceptionTest(ATTEMPT_COUNT_ERROR_MESSAGE.getMessage(), "a\n");
    }
}
