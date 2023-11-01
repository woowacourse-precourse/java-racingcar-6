package racingcar.validation;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class InputNumberValidationTest {

    @Test
    void 시도횟수_1보다_작을_때_예외_처리() {
        assertThatThrownBy(() -> {
            InputNumberValidation.validation("0");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도횟수_음수일_때_예외_처리() {
        assertThatThrownBy(() -> {
            InputNumberValidation.validation("-1");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도횟수_숫자가_아닐_때_예외_처리() {
        assertThatThrownBy(() -> {
            InputNumberValidation.validation("a");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
