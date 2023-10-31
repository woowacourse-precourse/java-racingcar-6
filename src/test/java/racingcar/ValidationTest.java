package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class ValidationTest {

    @Test
    void 차_개수_1이하_시_예외_발생() {
        String input = "pobi";

        assertThatThrownBy(() -> Validation.throwIfCarInputIsInvalid(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("2개 이상의 자동차를 입력해주세요.");
    }
    @Test
    void 음수_입력_시_예외_발생() {
        String input = "-1";

        assertThatThrownBy(() -> Validation.throwIfCountInputIsInvalid(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1이상의 숫자를 입력해주세요.");
    }

    @Test
    void 제로_입력_시_예외_발생() {
        String input = "0";

        assertThatThrownBy(() -> Validation.throwIfCountInputIsInvalid(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1이상의 숫자를 입력해주세요.");
    }
}