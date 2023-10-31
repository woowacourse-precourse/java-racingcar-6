package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class GameCountValidatorTest {

    @Test
    void validatet_숫자가_아닌_입력() {
        // given
        String input = "a12b";

        // when and then
        assertThatThrownBy(() -> new GameCountValidator().validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("게임 실행 횟수는 숫자만 입력해야 합니다.");
    }

    @Test
    void validate_0_입력() {
        // given
        String input = "0";

        // when and then
        assertThatThrownBy(() -> new GameCountValidator().validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("게임 실행 횟수는 양수만 입력해야 합니다.");
    }

    @Test
    void validate_0_으로_시작하는_입력() {
        // given
        String input = "07";

        // when and then
        assertThatThrownBy(() -> new GameCountValidator().validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("게임 실행 횟수 입력은 0으로 시작하면 안됩니다.");
    }

    @Test
    void validate_음수_입력() {
        // given
        String input = "-123";

        // when and then
        assertThatThrownBy(() -> new GameCountValidator().validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("게임 실행 횟수는 양수만 입력해야 합니다.");
    }
}