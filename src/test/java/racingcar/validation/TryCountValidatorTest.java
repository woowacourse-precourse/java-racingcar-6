package racingcar.validation;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class TryCountValidatorTest {
    @Test
    public void 입력값이_null이거나_비어있는_경우_검증() {
        String input = "";
        assertThatThrownBy(() -> TryCountValidator.validateTryCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도할 횟수를 입력하지 않았습니다. 숫자를 입력해주세요.");
    }

    @Test
    public void 입력값이_정수가_아닌_경우_검증() {
        String input = "abc";
        assertThatThrownBy(() -> TryCountValidator.validateTryCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("정수를 입력하세요.");
    }

    @Test
    public void 입력값이_0_이하인_경우_검증() {
        String input = "-1";
        assertThatThrownBy(() -> TryCountValidator.validateTryCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도할 횟수는 0보다 커야 합니다.");
    }

}
