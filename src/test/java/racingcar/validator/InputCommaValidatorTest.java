package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class InputCommaValidatorTest {

    @Test
    void validate_쉼표로_시작하는_입력() {
        // given
        String input = ",pobi";

        // when & then
        assertThatThrownBy(() -> new InputCommaValidator().validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름 입력이 (,) 쉼표로 시작되면 안됩니다.");
    }

    @Test
    void validate_쉼표_중첩된_입력() {
        // given
        String input = "pobi,,,,,,,woni";

        // when & then
        assertThatThrownBy(() -> new InputCommaValidator().validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름에는 (,) 연속된 쉼표를 입력해서는 안됩니다.");
    }

    @Test
    void validate_쉼표로_끝나는_입력() {
        // given
        String input = "pobi,";

        // when & then
        assertThatThrownBy(() -> new InputCommaValidator().validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름 입력 끝에는 (,) 쉼표가 있으면 안됩니다.");
    }
}