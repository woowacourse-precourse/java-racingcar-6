package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class ValidatorTest {
    @Test
    void 자동차_이름이_5글자_이상이면_예외() {
        assertThatThrownBy(() -> Validator.validateLength("123456")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름이_빈칸이면_예외() {
        assertThatThrownBy(() -> Validator.validateBlank("")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Validator.validateBlank("     ")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도_횟수가_숫자가_아니면_예외() {
        assertThatThrownBy(() -> Validator.validateTrialCount("i")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Validator.validateTrialCount("1e3")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Validator.validateTrialCount(" ")).isInstanceOf(IllegalArgumentException.class);
    }
}
