package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class TryNumberValidatorTest {
    @Test
    void 시도횟수_1보다_작을_때_예외_처리() {
        assertThatThrownBy(() -> {
            TryNumberValidator.validate("0");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도횟수_음수일_때_예외_처리() {
        assertThatThrownBy(() -> {
            TryNumberValidator.validate("-1");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도횟수_소수일_때_예외_처리() {
        assertThatThrownBy(() -> {
            TryNumberValidator.validate("1.2");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도횟수_숫자가_아닐_때_예외_처리() {
        assertThatThrownBy(() -> {
            TryNumberValidator.validate("a");
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
